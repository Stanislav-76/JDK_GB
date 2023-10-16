package Seminar3.work3;

/*
 * Описать интерфейс Person c методами doWork() и haveRest(). Написать два класса работник и бездельник,
 * реализубщих интерфейс. Работник работает и не умеет бездельничать, в то время как бездельник не
 * умеет работать, но умеет отдыхать. Написать обобщенные классы Workplace и Club, содкржащие массив 
 * из Person. В классах необходимо вызывать у всего массива людей соответствующие методы.
 */

public class Main {
    public static void main(String[] args) {
        Person person1 = new HardWorker();
        Person person2 = new HardWorker();
        Person person3 = new HardWorker();
        Person person4 = new HardWorker();
        Person person5 = new HardWorker();
        Person person6 = new Idler();
        Person person7 = new Idler();
        Person person8 = new Idler();
        Person person9 = new Idler();
        Person person10 = new Idler();

        Person[] workers = {person1, person7, person3, person9, person5};
        Person[] idlers = {person6, person2, person8, person4, person10};

        WorkPlace<? extends Person> factory = new WorkPlace<>(workers);
        NightClub<? extends Person> club = new NightClub<>(idlers);

        factory.workForAll();
        club.partyForAll();

        for (Person person : workers) {
            System.out.println(person);
        }
    }
}