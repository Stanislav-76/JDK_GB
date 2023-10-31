package Seminar5.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Race {
    private List<Runner> competitors;
    private List<Thread> threads;
    private boolean prepare = false;
    private boolean start = false;
    private boolean stop = false;
    private int distance = 100;

    public Race(Runner... runners) {
        competitors = new ArrayList<>();
        threads = new ArrayList<>();
        Collections.addAll(competitors, runners);
    }

    public void setThreads(){
        for (Runner runner : competitors) {
            Runnable run = () -> {
                while (!prepare) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                runner.setReady();

                while (!stop) {
//                    System.out.println("Wait for start.");
                    try {
                        Thread.sleep(100);
                    } catch(Exception e) {
                      e.printStackTrace();
                    }

                    if (start) {
                        runner.run(distance);
                    }
                }
            };
            Thread thread = new Thread(run);
            thread.start();
            threads.add(thread);
        }
    }

    public void start() {
        try {
            prepare = true;
            int flag = 0;

            while (flag != competitors.size()) {
                flag = 0;
                for (Runner competitor : competitors) {
                    if (competitor.isReady()) {
                        flag++;
                    }
                }
            }
            System.out.println("Everybody are ready!");

            System.out.println("Ready");
            Thread.sleep(200);
            System.out.println("Steady");
            Thread.sleep(200);
            System.out.println("Go!!!!");
            Thread.sleep(200);

            start = true;

            int allDone = 0;

            while (allDone != competitors.size()) {
                for (Runner competitor : competitors) {
                    if (competitor.getDistance() == distance) {
                        allDone++;
                    }
                }
            }

            stop = true;
            System.out.println("EveryBody finished!!!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}