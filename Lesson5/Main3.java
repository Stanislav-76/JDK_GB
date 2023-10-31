package Lesson5;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            try {
                Thread.sleep(10000);
                System.out.println("work done");
            } catch (InterruptedException e) {
                System.out.println("Interrrupted");
            }
        };
        Thread thread = new Thread(task);
        thread.start();
// Если метод join() вызывается на одном из потоков, то текущий Thread
// выполняющийся в этот момент блокируется до момента времени, пока поток, для
// которого вызван метод join не закончит свое выполнение
        thread.join();
        System.out.println("Finished");
    }
}
