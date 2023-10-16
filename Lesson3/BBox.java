import java.util.ArrayList;
import java.util.Arrays;

public class BBox<V extends Number> {
    private V value;

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    private static <T extends Number> void setIfNull(BBox<T> box, T t) { // extends ограничение сверху (upper bound)
        if (box.getValue() == null) {
            box.setValue(t);
        }
    }

    public static void copyTo(ArrayList src, ArrayList dst) {
        for (Object o: src) dst.add(o);
    }

    public static <T> void copyTo2(ArrayList<? extends T> src, ArrayList<? super T> dst) {
        for (T o: src) dst.add(o);
    }


    public static void main(String[] args) {
        BBox<Integer> integerBBox = new BBox<>();
        // BBox<String> stringBBox = new BBox<>(); // нельзя создать - ограничено Number

        setIfNull(integerBBox, 4);
        // setIfNull(stringBBox, "Hello");

        ArrayList<Integer> ial = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Number> nal = new ArrayList<>(Arrays.asList(1f, 2, 3.0));
        System.out.println(ial);
        System.out.println(nal);
        copyTo(ial, nal);  // правильный - копирование более точного типа в более общий список
        System.out.println(nal); // [1.0, 2, 3.0, 1, 2, 3]
        copyTo(nal, ial);
        System.out.println(ial); // [1, 2, 3, 1.0, 2, 3.0, 1, 2, 3]
        // copyTo2(nal, ial); // нельзя из-за ограничений

    }
}

class Bird{}
interface Animal{}
interface Man{}
class CBox<T extends Bird & Animal & Man>{}  // может быть только один класс наследник - указывается первым
