package Lesson5;

public class Main2 {
    public static void main(String[] args) {
// Если поток ожидает выполнения прерываемого метода блокирования (Thread.sleep(), Thread.join() или Object.wait()),
// то процесс ожидание прерывается и выбрасывает InterruptedException
        Runnable task = () -> {
            try {
                Thread.sleep(10000);
                System.out.println("Waked up");
            } catch (InterruptedException e) {
                System.out.println("Interrrupted");
            }
            while (Thread.currentThread().isInterrupted()) {
                
            }
            System.out.println("Finished");
        };
        Thread thread = new Thread(task);
        thread.start();
        thread.interrupt();
    }
}
