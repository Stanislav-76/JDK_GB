package Lesson1.TicTacToe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 230;
    private static final int WINDOW_WIDTH = 350;

    JButton btnStart = new JButton("Start new game");

    SettingsWindow(GameWindow gameWindow) {
        // setLocationRelativeTo(gameWindow);
        setLocation(gameWindow.getX() + (gameWindow.getWidth() - WINDOW_WIDTH) / 2,
                gameWindow.getY() + (gameWindow.getHeight() - WINDOW_HEIGHT) / 2);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        
        
        setLayout(new GridLayout(10, 1));
        add(new JLabel("Выберите режим игры"));
        ButtonGroup bg = new ButtonGroup();
        JRadioButton pvc = new JRadioButton("Человек против компьютера");
        JRadioButton pvp = new JRadioButton("Человек прротив человека");
        bg.add(pvc);
        bg.add(pvp);
        add(pvc);
        add(pvp);
        add(new JLabel("Выберите размеры поля"));
        JLabel lbFieldSize = new JLabel("Установленный размер поля: 3");
        add(lbFieldSize);
        JSlider slideFieldSize = new JSlider(3, 10, 3);
        add(slideFieldSize);
        add(new JLabel("Установите длину для победы"));
        JLabel lbWinLength = new JLabel("Установленная длина: 3");
        add(lbWinLength);
        JSlider slideWinLen = new JSlider(3, 10, 3);
        add(slideWinLen);
        slideFieldSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int current = slideFieldSize.getValue();
                lbFieldSize.setText("Установленный размер поля: " + current);
                slideWinLen.setMaximum(current);
            }
        });
        slideWinLen.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbWinLength.setText("Установленная длина: " + slideWinLen.getValue());
            }
        });
        
        add(btnStart);
        
        btnStart.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                int gameMode;
                if (pvc.isSelected()) {
                    gameMode = Field.MODE_PVC;
                } else if (pvp.isSelected()) {
                        gameMode = Field.MODE_PVP;
                } else {
                    throw new RuntimeException("Unknow game mode"); 
                }
                int fieldSize = slideFieldSize.getValue();
                int winLength = slideWinLen.getValue();
                gameWindow.startNewGame(gameMode, fieldSize, fieldSize, winLength);                
                // gameWindow.startNewGame(0, 3, 3, 3);
                setVisible(false);
            }
        });
    }
}
