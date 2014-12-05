package edu.nyu.cs.codinginterview.chapter04.graph;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class VertexFactory {
    private static int count = 0;
    private static Set<Vertex> vertices = new HashSet<Vertex>();
    
    private VertexFactory() {
        throw new AssertionError();
    }
    
    public static Vertex getVertex() {
        Vertex v = new Vertex(count++);
        vertices.add(v);
        return v;
    }
    
    public static Vertex getVertex(int id) {
        for (Vertex v : vertices) {
            if (id == v.getId()) {
                return v;
            }
        }
        return null;
    }
    
    public static Set<Vertex> getVertices() {
        return Collections.unmodifiableSet(vertices);
    }

}
