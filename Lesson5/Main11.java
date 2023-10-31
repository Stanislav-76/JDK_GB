package Lesson5;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
 * CyclicBarrier работает аналогично CountDownLatch, но есть несколько отличий:
 * вместо методов countDown() и await() используется один метод await(), после
 * вызова которого поток блокируется (если число не равно нулю);
 * класс CyclicBarrier можно использовать повторно. Как только значение
 * счетчика становится равным нулю, оно восстанавливается, и объект класса
 * можно использовать заново;
 * как только значение счетчика стало равным нулю, у вас есть возможность
 * выполнить дополнительный метод имплементирующий интерфейс runnable,
 * который может быть передан в конструктор CyclicBarrier.
 */

public class Main11 {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        new Car(3000, cyclicBarrier, "CAR-1").start();
        new Car(2000, cyclicBarrier, "CAR-2").start();
        new Car(1000, cyclicBarrier, "CAR-3").start();
        System.out.println(Thread.currentThread().getName() + " has finished");
    }

    static class Car extends Thread {
        private int delay;
        private CyclicBarrier cyclicBarrier;

        public Car (int delay, CyclicBarrier cyclicBarrier, String name) {
            super(name);
            this.delay = delay;
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                cyclicBarrier.await();
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }        
    }
}
