public class TBox<T> {
    private T value;
    public static final TBox EMPTY_BOX = new TBox<>();

    // <U> TBox(U u) {}

    static <T> TBox<T> emptyBox() {
        return (TBox<T>)EMPTY_BOX;
    }
    
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    static void printInfo(TBox<? extends Animals> animalInBox){
        System.out.println("Information about animal: " + animalInBox);    
    }


    @Override
    public String toString() {
        return value.toString();
    }

    public static void main(String[] args) {
                
        // TBox<Cat> box = new TBox<Cat>("еее");
        TBox<String> box1 = TBox.emptyBox();



        TBox<Cat1> catInBox = TBox.emptyBox();
        catInBox.setValue(new Cat1("Vasya"));
        printInfo(catInBox);

        TBox<Dog1> dogInBox = TBox.emptyBox();
        dogInBox.setValue(new Dog1("Kusya"));
        printInfo(dogInBox);


        // Наследование в параметрах типа через подстановочный символ
        Cat1 cat = new Cat1("Vasya");
        Animals animals = cat;
        TBox<? extends Cat1> catInBox2 = new TBox<>();
        // TBox<Animals> animalInBox = catInBox2; //так нельзя
        TBox<? extends Animals> animalInBox = catInBox2;
    }
    
}

class Animals{
    protected String name;

    protected Animals(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " with name " + name;
    }    
}

class Cat1 extends Animals{
    protected Cat1(String name){ super(name);}
}

class Dog1 extends Animals{
    protected Dog1(String name){ super(name);}
}