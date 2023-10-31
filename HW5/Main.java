package HW5;

public class Main {
    public static void main(String[] args) {
        Philosopher philosopher1 = new Philosopher("philosopher1");
        Philosopher philosopher2 = new Philosopher("philosopher2");
        Philosopher philosopher3 = new Philosopher("philosopher3");
        Philosopher philosopher4 = new Philosopher("philosopher4");
        Philosopher philosopher5 = new Philosopher("philosopher5");

        ActivityPhilosophers philosophers = new ActivityPhilosophers(philosopher1, philosopher2, philosopher3,
                philosopher4, philosopher5);

        philosophers.setThreads();
    }
}