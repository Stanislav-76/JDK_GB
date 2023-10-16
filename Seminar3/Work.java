/**
 * Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа (T, V, K),
 * методы возвращающие значения трех переменных. Создать метод, выводящий на консоль имена классов для
 * трех переменых класса. Наложить ограничения на параметры типа: T должен реализвать интерфейс Comparable,
 * (классы оболочки String), V должен реализовать интерфейс DataInput и расширять класс InputStream, K должен 
 * расширять класс Number.
 */

package Seminar3;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream; 

public class Work <T extends Comparable, V extends DataInput , K extends Number> {
    T comparableItem;    
    V dataItem;
    K numberItem;
    
    Work(T comparableItem, V dataItem, K numberItem) {
        this.comparableItem = comparableItem;
        this.dataItem = dataItem;
        this.numberItem = numberItem;
    }
    
    public void getNameClass() {
        System.out.println(comparableItem.getClass().getName());
        System.out.println(dataItem.getClass().getName());
        System.out.println(numberItem.getClass().getName());
    }


    public static void main(String[] args) throws FileNotFoundException {
        InputStream  is = new DataInputStream(new FileInputStream("Seminar3\\test.txt"));
        Work<String, DataInputStream, Integer> work = new Work<>("any", new DataInputStream(is), 3);
        work.getNameClass();
    }        
    
}
