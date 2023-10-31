package HW5;

import java.util.Random;

public class Philosopher {
    private final String name;
    private final Random random = new Random();

    Philosopher(String name) {
        this.name = name;
    }

    /**
     * Метод философ размышляет
     */
    public void thinking() {
        System.out.println(name + " размышляет");
        try {
            Thread.sleep(random.nextInt(2000 - 1000) + 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод философ обедает
     */
    public void havingLunch() {
        System.out.println(name + " обедает");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
   

