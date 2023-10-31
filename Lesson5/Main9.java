package Lesson5;

import java.util.concurrent.Exchanger;

/*
 * Exchanger — точка синхронизации, позволяющая двум потокам обмениваться значениями.
 * При создании экземпляра Exchanger указывается тип объекта, которым будут 
 * обмениваться потоки. Когда поток вызывает метод exchange(), а другой поток не готов 
 * к обмену значениями, текущий поток переходит в состояние WAITING. Этот класс стоит 
 * использовать для обмена значениями между двумя потоками.
 * Также у класса есть перегруженный метод exchange, который принимает время, которое поток будет
 * находится в состоянии WAITING — в этом случае если процесс обмена не завершился,
 * то генерируется проверяемое исключение TimeOutException
 */

public class Main9 {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<String>();
        new Thread(new NewThread(ex, "First message", "First Thread")).start();
        new Thread(new NewThread(ex, "Second message", "Second Thread")).start();
    }

    static class NewThread implements Runnable {
        Exchanger<String> exchanger;
        String message;
        String name;
        
        public NewThread(Exchanger<String> exchanger, String message, String name) {
            this.exchanger = exchanger;
            this.message = message;
            this.name = name;
        }

        public void run() {
            try {
                message = exchanger.exchange(message);
                System.out.println(name + " has received: " + message);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
