public class GBox<T> {
    private T value;

    public GBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public void showType() {
        System.out.printf("Type is %s, with value %s\n", value.getClass().getName(), getValue());
    }

    private static <T> void setIfNull(GBox<T> box, T t) {  //обобщенный метод
        if (box.getValue() == null) {
            box.setValue(t);
        }
    }

    private static void boxTest(GBox<Number> n) {}


    public static void main(String[] args) {
        GBox<String> stringBox = new GBox<String>("Hello!");
        stringBox.showType(); // Type is java.lang.String, with value Hello!
        GBox<Integer> integerBox =  new GBox<>(12);
        integerBox.showType(); // Type is java.lang.Integer, with value 12


        // Raw type (сырой тип)
        GBox<Integer> intBox = new GBox<>(1);
        GBox box = intBox;
        box.setValue(4);

        GBox box2 = new GBox<>(1);
        GBox<Integer> intBox2 = box2;


        // Обобщенные методы
        GBox<Integer> box3 = new GBox<Integer>(null);
        setIfNull(box3, 13);
        System.out.println(box3.getValue());
        GBox<Integer> box4 = new GBox<Integer>(1);
        setIfNull(box4, 13);
        System.out.println(box4.getValue());


        // boxTest(new GBox<Number>(10));
        // boxTest(new GBox<Integer>(1)); // нельзя положить не Number
        // boxTest(new GBox<Float>(1.0f));

        
    }    
}
