package Lesson5;

public class Main {
    public static void main(String[] args) {
        
        System.out.println(Thread.currentThread().getName());

        // Объект Runnable передается конструктору класса Thread. Наиболее гибкий способ.
        Runnable task = new Runnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("Make some work!");
            }
        };
        Thread thread = new Thread(task);
        thread.start();

        // объявить подкласс Thread, предоставляя собственную реализацию метода run. 
        // Данный способ больше подходит для “простых” приложений
        ExampleThread exampleThread = new ExampleThread();
        exampleThread.start();
    }

    public static class ExampleThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            System.out.println("Make some work!");
        }
    }
}
