package edu.nyu.cs.codinginterview.chapter03.animals;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.nyu.cs.codinginterview.util.Check;

/**
 * @author shenli
 * <p>
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis. People 
 * must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select 
 * whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot 
 * select which specific animal they would like. Create the data structure to maintain this system and 
 * implement operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.
 */
public class Shelter {
    private Map<AnimalType, AnimalQueue<Animal>> queues;
    
    public Shelter() {
        queues = new HashMap<AnimalType, AnimalQueue<Animal>>();
    }
    
    public Animal deQueue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        return queues.get(minimum()).deQueue();
    }
    
    public Animal deQueue(AnimalType type) {
        Check.nullCheck(type, "animal type");
        
        if (!queues.containsKey(type)) {
            throw new NoSuchElementException();
        }
        return queues.get(type).deQueue();
    }
    
    public boolean enQueue(AnimalType type) {
        Check.nullCheck(type, "animal type");
        
        if (!queues.containsKey(type)) {
            queues.put(type, new AnimalQueue<Animal>());
        }
        queues.get(type).enQueue(
                AnimalFactory.getAnimal(type));
        return true;
    }
    
    public boolean isEmpty() {
        for (Map.Entry<AnimalType, AnimalQueue<Animal>> entry : queues.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean isEmpty(AnimalType type) {
        Check.nullCheck(type, "animal type");
        
        if (!queues.containsKey(type)) {
            return true;
        }
        return queues.get(type).isEmpty();
    }
    
    public Animal peek() {
        if (isEmpty()) {
            return null;
        }
        return queues.get(minimum()).peek();
    }
    
    public Animal peek(AnimalType type) {
        Check.nullCheck(type, "animal type");
        
        if (!queues.containsKey(type)) {
            return null;
        }
        return queues.get(type).peek();
    }
    
    public int size() {
        int size = 0;
        for (Map.Entry<AnimalType, AnimalQueue<Animal>> entry : queues.entrySet()) {
            size += entry.getValue().size();
        }
        return size;
    }
    
    public int size(AnimalType type) {
        Check.nullCheck(type, "animal type");
        
        if (!queues.containsKey(type)) {
            return 0;
        }
        return queues.get(type).size();
    }
    
    private AnimalType minimum() {
        AnimalType type = null;
        Animal min = null;
        AnimalQueue<Animal> animals = null;
        for (Map.Entry<AnimalType, AnimalQueue<Animal>> entry : queues.entrySet()) {
            animals = entry.getValue();
            if (!animals.isEmpty()) {
                if (min == null || min.compareTo(animals.peek()) > 0) {
                    min = animals.peek();
                    type = entry.getKey();
                }
            }
        }
        return type;
    }
    
}
