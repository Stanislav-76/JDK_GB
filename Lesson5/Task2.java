package Lesson5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task2 implements Runnable {

    // private int value;
    private  final AtomicInteger value;  // вариант синхронизации с AtomicInteger
    private CountDownLatch cdl;    
    
    public Task2(int left ) {
        // this.value = left;
        this.value = new AtomicInteger(left);
    }

    public void inc() {    
        value.incrementAndGet();
    }

    // синхронизированный метод
    // public synchronized void inc() {
    //     value++;
    // }

    // равнозначная запись, но синхр. блок внутри функции - быстрее работает
    // public void inc() {
    //     synchronized (Task2.class) {
    //         value++;
    //     }
    // }

    
    public int getValue() {
        // return value;
        return value.intValue();
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            inc();
        }
        cdl.countDown();
    }
    
    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
