/**
 * Описать собственную коллекцию - список на основе массива. Коллекция должна иметь 
 * возможность храниить любые типы данных, иметь методы добавления и удаления элементов.
 */

package Seminar3;

import java.util.Iterator;

public class ParamCollection<T> implements Iterable<T> {
    private T[] array;
    private int index = 0;
    private int size;

    public ParamCollection(T[] array) {
        this.array = array;
        this.size = array.length;
    }    
    
    public int getSize() {
        return size;
    }

    public T getByIndex(int index) {
        return array[index];
    }

    public void add(T item) {
        if (index < size) {
            array[index] = item;
            index++;
        } else throw new RuntimeException("Array is Full!");    
    }    
    
    public void delete(int index){
        array[index] = null;
    }

    public void print(){
        for (T t : array) {
            System.out.printf(t + " ");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ParamIterator<>(this);
    }
}

class Main {
    public static void main(String[] args) {
        ParamCollection<Double> paramCollection = new ParamCollection<>(new Double[10]);
        paramCollection.add(2.0);
        paramCollection.add(1.0);
        paramCollection.add(3.0);
        paramCollection.delete(0);
        paramCollection.print();
        for (Double dc : paramCollection) {
            System.out.println(dc);
        }
    }
}