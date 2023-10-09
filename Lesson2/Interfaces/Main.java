package Interfaces;

public class Main {
    public static void main(String[] args) {
        Man man0 = new Man();   //class Man
        Ox ox0 = new Ox();      //clas Ox
        Human man1 = new Man(); //interface Human
        Bull ox1 = new Ox();    //interface Bull

        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();
        Minotaurus minos = new Minotaurus();
        Human man2 = new Man();
        Bull ox2 = new Ox();
        Bull[] allBulls = {ox2, minos0, minos};
        Human[] allHumans = {man2, minos, minos1}; 
    }
}