package Lesson5;

/*
 * ThreadLocal гарантирует, что каждый поток будет работать со своей уникальной переменной
 * Класс ThreadLocal представляет хранилище тред-локальных переменных. По
 * способу использования он похож на обычную обертку над значением, с методами
 * get(), set() и remove() для доступа к нему, и дополнительным фабричным методом
 * ThreadLocal.withInitial(), устанавливающим значение по-умолчанию
 */

public class Main7 {
    private static Integer counter = 0;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new ThreadTask()).start();
        new Thread(new ThreadTask()).start();
    }
    
    public static class ThreadTask implements Runnable {
        ThreadLocal<Integer> threadCounter = new ThreadLocal<>();
    
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                counter++;
                if (threadCounter.get() != null) {
                    threadCounter.set(threadCounter.get() + 1);
                } else {
                    threadCounter.set(0);
                }
            }
            System.out.println("Counter: " + counter);
            System.out.println("threadLocalCounter: " + threadCounter.get());
        }
    }
}


