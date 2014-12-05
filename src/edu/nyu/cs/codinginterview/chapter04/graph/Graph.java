package edu.nyu.cs.codinginterview.chapter04.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.nyu.cs.codinginterview.util.Check;
import edu.nyu.cs.codinginterview.util.Queue;
import edu.nyu.cs.codinginterview.util.Stack;

/**
 * @author shenli
 * <p>
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */
public class Graph {
    private final Map<Integer, List<Integer>> adjacent;
    
    public Graph(Set<Vertex> vertices, Set<Edge> edges) {
        Check.nullCheck(vertices, "vertices");
        Check.nullCheck(edges, "edges");
        for (Vertex v : vertices) {
            Check.nullCheck(v, "vertex");
        }
        for (Edge e : edges) {
            Check.nullCheck(e, "edge");
        }
        
        this.adjacent = new HashMap<Integer, List<Integer>>();
        int vertexId = 0;
        for (Vertex v : vertices) {
            vertexId = v.getId();
            if (!adjacent.containsKey(vertexId)) {
                adjacent.put(vertexId, new ArrayList<Integer>());
            }
            for (Edge e : edges) {
                if (vertexId == e.getStart().getId()) {
                    adjacent.get(vertexId).add(e.getEnd().getId());
                }
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    public List<Integer> adjacentList(int id) {
        if (!adjacent.containsKey(id)) {
            return (List<Integer>) Collections.EMPTY_LIST;
        }
        return Collections.unmodifiableList(adjacent.get(id));
    }
    
    public boolean searchBFS(Vertex start, Vertex end) {
        Check.nullCheck(start, "start vertex");
        Check.nullCheck(end, "end vertex");
        
        int startId = start.getId();
        int endId = end.getId();
        if (!adjacent.containsKey(startId)
                || !adjacent.containsKey(endId)) {
            return false;
        }
        
        Queue<Integer> queue = new Queue<Integer>();
        VertexFactory.getVertex(startId).state = State.VISITING;
        queue.enQueue(startId);
        while (!queue.isEmpty()) {
            int vertexId = queue.deQueue();
            if (vertexId == endId) {
                return true;
            } else {
                Vertex v = VertexFactory.getVertex(vertexId);
                List<Integer> adj = adjacentList(vertexId);
                for (Integer i : adj) {
                    Vertex u = VertexFactory.getVertex(i);
                    if (u.state == State.UNVISITED) {
                        u.state = State.VISITING;
                        u.parent = v;
                        queue.enQueue(u.id);
                    }
                }
                v.state = State.VISITED;
            }
        }
        return false;
    }
    
    public boolean searchDFS(Vertex start, Vertex end) {
        Check.nullCheck(start, "start vertex");
        Check.nullCheck(end, "end vertex");
        
        int startId = start.getId();
        int endId = end.getId();
        if (!adjacent.containsKey(startId)
                || !adjacent.containsKey(endId)) {
            return false;
        }
        start.state = State.VISITING;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(startId);
        while (!stack.isEmpty()) {
            int vertexId = stack.peek();
            if (vertexId == endId) {
                return true;
            } else {
                Vertex v = VertexFactory.getVertex(vertexId);
                int uId = checkStates(adjacentList(vertexId));
                if (uId == -1) {
                    vertexId = stack.pop();
                    v.state = State.VISITED;
                } else {
                    Vertex u = VertexFactory.getVertex(uId);
                    u.parent = v;
                    u.state = State.VISITING;
                    stack.push(u.id);
                }
            }
        }
        return false;
    }
    
    private int checkStates(List<Integer> adj) {
        for (Integer id : adj) {
            Vertex v = VertexFactory.getVertex(id);
            if (v.state == State.UNVISITED) {
                return id;
            }
        }
        return -1;
    }

}
