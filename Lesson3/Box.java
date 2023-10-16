public class Box {
    private Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void printInfo() {
        System.out.printf("Box (%s): %s\n", obj.getClass().getSimpleName(), obj.toString());
    }

    public static void main(String[] args) {
        Box b1 = new Box(20);
        Box b2 = new Box(30);
        b1.printInfo();
        System.out.println((Integer) b1.getObj() + (Integer) b2.getObj());
        Box b3 = new Box("Hello, ");
        Box b4 = new Box("World!");
        b3.printInfo();
        System.out.println((String) b3.getObj() + (String) b4.getObj());

        Box iBox1 = new Box(20);
        Box iBox2 = new Box(30);
        if (iBox1.getObj() instanceof Integer && iBox2.getObj() instanceof Integer) {
            int sum  = (Integer)iBox1.getObj() + (Integer)iBox2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The contents of the boxes differ by type");
        }
        iBox1.setObj("iBox2"); // положили другой тип данных   
    }
}
