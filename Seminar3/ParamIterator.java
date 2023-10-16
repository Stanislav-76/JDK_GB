/*
 * Написать итератор по массиву. Итератор - это объект, осуществляющий движение по
 * коллекциям любого типа, содержащим любые типы данных. Итераторы обычно имеют только
 * два метода - проверка на наличие следующего элемента и переход к следующему элементу.
 * Но также, особенно в других языках программирования, возможно встретить итераторы,
 * реализующие дополнительную логику.
 */

package Seminar3;

import java.util.Iterator;

public class ParamIterator<T> implements Iterator<T> {
    private final ParamCollection<T> collection;

    private int index = 0;

    public ParamIterator(ParamCollection<T> collection) {
        this.collection = collection;
    }

    @Override
    public boolean hasNext() {
        return index < collection.getSize();
    }

    @Override
    public T next() {
        T item = collection.getByIndex(index);
        index++;
        return item;
    }
}