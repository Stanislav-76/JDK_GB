package Seminar3.work3;

import java.util.Iterator;

import Seminar3.ParamCollection;

public class NightClub<T extends Person>  implements Iterable<T> {
    private T[] community;

    public NightClub(T[] community) {
        this.community = community;
    }

    public void partyForAll(){
        for (T t : community) {
            t.haveRest();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ParamIterator<T>();
    }

    class ParamIterator<T extends Person> implements Iterator<T> {

    private int index = 0;

    @Override
    public boolean hasNext() {
        return index < community.length;
    }

    @Override
    public T next() {
        T item = (T)community[index];
        index++;
        return item;
    }
}

}