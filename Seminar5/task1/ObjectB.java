/*
 * Создать два класс ObjectA, ObjectB
 * Реализовать класс в котором два потока вызовут DeadLock
 */
package Seminar5.task1;

public class ObjectB {
    int value = 20;

    public synchronized int getValue() throws InterruptedException {
        Thread.sleep(5000);
        return value;
    }

    public synchronized void setValue(int value) {
        this.value = value;
    }
    
}
