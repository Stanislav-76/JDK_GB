package Circles_v2.circles;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import Circles_v2.common.CanvasRepaintListener;
import Circles_v2.common.Interactable;
import Circles_v2.common.MainCanvas;

public class MainWindow extends JFrame implements CanvasRepaintListener {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDJW_HEIGHT = 600;
    private final Interactable[] sprites  = new Interactable[10];

    private MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDJW_HEIGHT);
        setTitle("Circles");
        sprites[0] = new Background();
        for (int i = 1; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
        MainCanvas canvas = new MainCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }            
        });        
        add(canvas);
        setVisible(true);
    }

    @Override
    public void onDrawFrame(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }
    private void render(MainCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}

