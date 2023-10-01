package Lesson1.TicTacToe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GameWindow extends JFrame{

    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;

    JButton btnStart = new JButton("New game");
    JButton btnExit = new JButton("Exit");

    Field field;
    SettingsWindow settings;

    GameWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);

        field = new Field();
        settings = new SettingsWindow(this);


        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        add(field);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                settings.setVisible(true);
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });        

        setVisible(true);
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        field.startNewGame(mode, fSzX, fSzY, wLen);
        // repaint();
    }

}