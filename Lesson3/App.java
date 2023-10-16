import java.util.ArrayList;
import java.util.List;

public class App {
    public static <U> void addBox(U u, List<GBox<U>> boxes) {
        GBox<U> box = new GBox<>(u);
        box.setValue(u);
        boxes.add(box);
    }

    public static void main(String[] args) {

        ArrayList<GBox<Cat>> catsInBoxes = new ArrayList<>();
        App.<Cat>addBox(new Cat("Kusya"), catsInBoxes);
        addBox(new Cat("Kusya"), catsInBoxes);
        addBox(new Cat("Murka"), catsInBoxes);
        System.out.println(catsInBoxes);
        for (GBox<Cat> gBox : catsInBoxes) {
            System.out.println(gBox.getValue().getName());
        }
    }
}

 class Cat { 
    String name;

    
    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


