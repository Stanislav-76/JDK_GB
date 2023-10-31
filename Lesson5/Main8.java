package Lesson5;

import java.util.concurrent.Semaphore;

/*
 * Semaphore один из примитивов синхронизации, позволяющий определить N потоков, которым позволено исполнять критическую секцию кода. 
 * Можно в методе захвата семафора (acquire()) указать, какое количество пропусков возьмет поток, а
 * в методе освобождения (release()) сколько будет возвращено (это количество не может быть больше,
 *  чем захваченное количество пропусков).
 * Если передать в конструктор вторым параметром true, потоки, которые ожидают
 * получение пропуска (хотят войти в критическую секцию), выстраиваются в очередь
 * (вместо blocking set используется очередь по типу FIFO).  
 */

public class Main8 {
    private static Integer count = Integer.valueOf(0);
    public static void main(String[] args) {

        Semaphore sem = new Semaphore(2); // N разрешений

        new Thread(new CountThread(sem)).start();
        new Thread(new CountThread(sem)).start();
        new Thread(new CountThread(sem)).start();
    }
    
    static class CountThread implements Runnable {
        Semaphore sem;
    
        public CountThread(Semaphore sem) {
            this.sem = sem;
        }

        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " ожидает разрешение");
                sem.acquire(); // получение разрешения у семафора
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ": " + count);
                    count++;
                    Thread.sleep(100);
                }            
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println(Thread.currentThread().getName() +  " освобождает разрешение");
            sem.release(); // Освобождение монитора
        }
    }
}



