package HW5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivityPhilosophers {
    private final List<Philosopher> philosophers;

    public ActivityPhilosophers(Philosopher... philosopher) {
        philosophers = new ArrayList<>();
        Collections.addAll(philosophers, philosopher);
    }

    public void setThreads() {
        for (Philosopher philosopher : philosophers) {
            Runnable runnable = () -> {
                int count = 3;
                while (count != 0) {
                    philosopher.havingLunch();
                    philosopher.thinking();
                    count--;
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }
}