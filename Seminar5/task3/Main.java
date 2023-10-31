/*
 * 3 бегуна должны прийти к старту гонки
 * Программа должна гарантировать, что гонка начнется только когда все три участника будут на старте
 * Программа должна отсчитать “На старт”, “Внимание”, “Марш”
 * Программа должна завершиться когда все участники закончат гонку.
 */

package Seminar5.task3;

public class Main {
    public static void main(String[] args) {
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        Runner runner3 = new Runner();
        Race race = new Race(runner1, runner2, runner3);
        race.setThreads();
        race.start();
    }
}

