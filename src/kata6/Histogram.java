/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author Eduardo
 * @param <T>
 */
public class Histogram<T> {

    private final HashMap<T, Integer> map;

    public Histogram(Iterator<T> iterator) {
        this(iterableOf(iterator));
    }

    private static <X> Iterable<X> iterableOf(Iterator<X> iterator){
        return () -> iterator;
    }

    public Histogram(Iterable<T> iterable) {
        this.map = new HashMap<>();
        for (T item : iterable) 
            add(item);
    }

    private void add(T item){
        map.put(item, get(item) + 1);
    }
    
    private int get(T item){
        return map.containsKey(item) ? map.get(item) : 0;
    }

}