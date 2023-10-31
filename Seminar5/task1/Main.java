package Seminar5.task1;

public class Main {
    public static void main(String[] args) {
        ObjectA objectA = new ObjectA();
        ObjectB objectB = new ObjectB();

        Runnable run1 = () -> {
            try {
                int value;
                value = objectA.getValue();
                objectB.setValue(value);
                System.out.println("value = " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }            
        };

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                int value;
                try {
                    value = objectB.getValue();
                    objectA.setValue(value);
                    System.out.println("value = " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);
        thread1.start();
        thread2.start();

    }
}
