package Seminar2.work3;

public class Animal implements Runnable, Eater {

    @Override
    public void eat() {}

    @Override
    public void run() {}

    public static void main(String[] args) {
        new Animal().sleep();
    }
    
}

