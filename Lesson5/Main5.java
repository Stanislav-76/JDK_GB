package Lesson5;

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        Object objectToLock = new Object();

        Runnable task = () -> {
            synchronized(objectToLock) {
                System.out.println(Thread.currentThread().getName());
            }
        };
        Thread thread = new Thread(task);
        thread.start();
        //Если необходимо, чтоб task выполнился раньше используем метод join()
        // thread.join();
        synchronized(objectToLock) {
            for (int i = 0; i < 10; i++) {
                Thread.currentThread().sleep(1000);
                System.out.println("step " + i);
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
