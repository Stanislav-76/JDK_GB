package anonimClass;

public class Main {

    public interface MouseListener {
        void mouseUp();
        void mouseDown();
    }

    private static void addMouseListener(MouseListener l) {
        l.mouseDown();
        l.mouseDown();
    }

    private static class MouseAdapter implements MouseListener {

        @Override
        public void mouseUp() { }
    
        @Override
        public void mouseDown() { }
    
    }
    public static void main(String[] args) {
        MouseAdapter m = new MouseAdapter();
        m.mouseUp();
        m.mouseDown();
        addMouseListener(m);

        addMouseListener(new MouseAdapter()); //экземпляр адаптера без идентификатора

        MouseListener l = new MouseListener() {    //экземпляр анонимного класса, который реализует интерфейс MouseListene
            @Override public void mouseUp() { }
            @Override public void mouseDown() { }            
        };
        addMouseListener(l);

        // в метод передаётся новый экземпляр анонимного класса который реализует интерфейс слушателя
        addMouseListener (new MouseListener() {  
            @Override public void mouseUp() { }
            @Override public void mouseDown() { }
        });
    };
}




