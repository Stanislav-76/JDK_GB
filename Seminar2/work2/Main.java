package Seminar2.work2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Fullstack dev = new DeveloperFull();
        Backender devback = new DeveloperBack();
        List<Backender> devlist = Arrays.asList(dev, devback);
        for (Backender backender : devlist) {
            backender.createServer();
        }
        dev.createServer();
        dev.createFront();
        devback.createServer();

        Developer dev2 = new DeveloperFront();
        if (dev2 instanceof Frontender) {
            ((Frontender) dev2).createFront();
        }
    }
}

interface Backender {
    void createServer();
}

interface Frontender {
    void createFront();
}

interface Fullstack extends Backender, Frontender {}

class DeveloperFull implements Fullstack {

    @Override
    public void createServer() {
        System.out.println("Сделал сервер");
    }

    @Override
    public void createFront() {
        System.out.println("Сделал фронт");
    }
}

class DeveloperBack implements Backender {

    @Override
    public void createServer() {
        System.out.println("Уронил сервер");
    }
}

abstract class Developer {}

class DeveloperFront extends Developer implements Frontender {
        @Override
    public void createFront() {
        System.out.println("Сделал фронт!");
    }
}