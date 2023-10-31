package Lesson5;

/*
 * Два потока пытаются в параллели получить доступ к одному и тому же объекту
 * последовательность запуска потоков отличается каждый раз, необходимо синхронизировать
 */
public class Main4 {
    static Integer object = Integer.valueOf(0);
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            object = object + 1;
            System.out.println(Thread.currentThread().getName());
        };
        Thread thread = new Thread(task);
        thread.start();
        System.out.println(Thread.currentThread().getName());
        object = object + 1;
        System.out.println(object.intValue());        
    }
}
