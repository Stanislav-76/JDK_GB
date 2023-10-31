/*
 * Создайте два потока A и B.
 * Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд (true в состояние false и наоборот).
 * Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100 с задержкой 100 миллисекунд
 * и приостанавливает свое действие, как только поток A переключит switcher в состояние false. 
 * Условием завершения работы потоков является достижение отсчета нулевой отметки.
 */
package Seminar5.task2;

public class Main {
    private static boolean switcher = true;
    private static int count  = 100;

    public static void main(String[] args) {
        Runnable run1 = () -> {
            try {
                while (count > 0) {
                    switcher = !switcher;
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        Runnable run2 = () -> {
            try {
                while (count > 0) {
                    if (switcher) {
                        count--;
                        System.out.println(count);
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread thread1 = new Thread(run1);
        Thread thread2 = new Thread(run2);

        thread1.start();
        thread2.start();
    }
}
