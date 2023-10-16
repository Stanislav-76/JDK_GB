package Homework3.DataBase;

import java.util.ArrayList;
import java.util.List;

public class DataBase<T> implements OpenData{
    private final List<T> data;

    public DataBase()  {
        this.data = new ArrayList<>();
    }

    @Override
    public void load() {
        //....
        System.out.println("Данные загружены");
    }

    @Override
    public void save() {
        //....
        System.out.println("Данные сохранены");
    }    

    @Override
    public void remove(int index) {
        data.remove(index);
        System.out.println("Данные удалены");
    }

}

class Main {
    public static void main(String[] args) {
        DataBase<String> rr = new DataBase<>();
        rr.load();
    }
}