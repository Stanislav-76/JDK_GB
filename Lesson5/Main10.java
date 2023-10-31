package Lesson5;

import java.util.concurrent.CountDownLatch;

/*
 * CowntDownLatch — это счетчик значение которого уменьшается каждый раз, когда
 * поток использует счетчик (поток при этом блокируется). Когда значение счетчика
 * будет равно нулю, все заблокированные потоки будут одновременно запущены.
 * Для уменьшения числа в счетчике вызывается метод countDown(). 
 * После вызова этого метода поток продолжает свое выполнение.
 * Метод await() используют для блокировки потока.
 */

public class Main10 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        new Car(3000, latch, "CAR-1").start();
        new Car(2000, latch, "CAR-2").start();
        new Car(1000, latch, "CAR-3").start();
        // Ждем три потока
        latch.await();
        System.out.println(Thread.currentThread().getName() + " has finished");
    }

    static class Car extends Thread {
        private int delay;
        private CountDownLatch latch;

        public Car (int delay, CountDownLatch latch, String name) {
            super(name);
            this.delay = delay;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
                latch.countDown();
                System.out.println(Thread.currentThread().getName() + " finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    
        
    }
}
