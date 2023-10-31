package Homework5;

/*
 * Есть пять философов (потоки), которые могут либо обедать, либо размышлять.
 * Каждый философ должен пообедать три раза.
 * Каждый прием пищи длиться 500 миллисекунд.
 * После каждого приема пищи философ должен размышлять.
 * Не должно возникнуть общей блокировки.
 * Философы не должны есть больше одного раза подряд.
 */

public class Main {
    public static void main(String[] args) throws RuntimeException, InterruptedException {
        Philosopf work = new Philosopf();
        Philosopf work2 = new Philosopf();
        Philosopf work3 = new Philosopf();
        Philosopf work4 = new Philosopf();
        Philosopf work5 = new Philosopf();
        Thread thread = new Thread(work, "Философ-1");
        Thread thread2 = new Thread(work2, "Философ-2");
        Thread thread3 = new Thread(work3, "Философ-3");
        Thread thread4 = new Thread(work4, "Философ-4");
        Thread thread5 = new Thread(work5, "Философ-5");
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();        
    }
}
class Philosopf implements Runnable{
    
    private int count;

    public Philosopf() {
        this.count = 0;
    }

    //Метод философ размышляет
    private void thinking() {
        System.out.println(Thread.currentThread().getName() + " размышляет");
    }

    //Метод философ обедает
    private void havingLunch() {
        System.out.println(Thread.currentThread().getName() + " обедает");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (count < 3) {
                havingLunch();
                count++;
                thinking();
        }
    }
    
}