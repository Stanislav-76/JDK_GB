package Lesson5;

public class TicTac implements Runnable {

    private final String bracket;
    private final Object monitor;    

    public TicTac(String bracket) {
        this.bracket = bracket;
        this.monitor = TicTac.class;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                System.out.print(bracket);
                try {
                    Thread.sleep(300);
                    monitor.notify();
                    monitor.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException();
                }
            }
        }
    }
    public static void main(String[] args) {
        Thread tic = new Thread(new TicTac("["));
        Thread tac = new Thread(new TicTac("]"));
        tic.start();
        tac.start();
    }    
}