/*
 * Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
 * Класс должен иметь методы getFirst(), getSecond() для получения значений пары, а также
 * переопределение метода toString(), возвращающее строковое значение пары.
 */

package Homework3;

class Pair<T, E> {
    T first;
    E second;

    public Pair(T first, E second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "Pair [first=" + getFirst() + ", second=" + getSecond() + "]";
    }
}

class Main {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("h", 3);
        System.out.println(pair);
    }
}
