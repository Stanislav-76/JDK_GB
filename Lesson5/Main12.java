package Lesson5;

import java.util.concurrent.locks.ReentrantLock;

/*
 * Одна из реализаций интерфейса Lock — ReentrantLock. Он позволяет одному и тому же потоку
 *  вызывать метод lock, даже если он его вызывал ранее, без освобождения блокировки.
 * void lock() — захват блокировки (если доступна). Если блокировка занята
 * другим потоком, текущий поток, который выполняет этот код, переходит в
 * статус BLOCKED;
 * void lockInterruptibly() — аналог lock(), но позволяет прервать блокированный
 *  поток и восстановить выполнение через InterruptedException;
 * boolean tryLock() — неблокирующий вариант метода lock(). Если удалось
 * получить блокировку, то метод возвращает true;
 * boolean tryLock(long timeout, TimeUnit timeUnit) — то же, что tryLock(), за исключением того,
 *  что метод ждет определенное время, перед тем остановить попытку получения блокировки;
 * void unlock() — отпускает блокировку.
 *  Фабричный метод newCondition() возвращает объект Condition, который позволяет
 * добавить текущий поток в wait set данного объекта Condition. Это дает возможность
 * организовывать разные условия ожидания по одной и той же блокировке, чего не
 * позволяют ключевое слово synchronized и связки методов wait()/notify(). Для того
 * чтоб объект попал в wait set для данного Condition объекта, нужно вызвать метод
 * await(). Чтобы разбудить поток или потоки, которые есть в wait set, необходимо
 * вызвать методы signal() или signalAll(). Эти методы аналогичны методам wait(),
 * notify() и notifyAll() у объекта Object (методы wait(), notify() и notifyAll() в объекте
 * Object — final, методам для объекта Condition придумали другие наименования).
 */

public class Main12 {
    static Integer resourse = Integer.valueOf(0);
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock locker = new ReentrantLock(); // создаем Lock
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new LockThread(locker));
            thread.start();
            thread.join();
        }
    }

    static class LockThread implements Runnable {
        ReentrantLock locker;

        LockThread(ReentrantLock locker) {
            this.locker = locker;
        }

        public void run() {
            locker.lock(); // устанавливаем блокировку
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.printf("%s %d \n", Thread.currentThread().getName(), resourse.intValue());
                    resourse++;
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } finally {
                locker.unlock();
            }
        }
    }
}
