package Lesson1.TicTacToe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JPanel;

public class Field extends JPanel{

    private int panelWidth;
    private int panelHeight;
    private int cellWidth;
    private int cellHeight;

    private static final Random RANDOM = new Random();
    private static int DOT_PADDING = 10;

    private boolean isGameOver;
    private boolean isInitialized;

    public static final int MODE_PVC = 0;
    public static final int MODE_PVP = 1;

    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;

    private static final String MSG_WIN_HUMAN = "Победил игрок!";
    private static final String MSG_WIN_AI = "Победил компьютер!";
    private static final String MSG_DRAW = "Ничья!";


    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeX = 3;
    private int fieldSizeY = 3;
    private char[][] field;
    private int winLength=3;

    private void initField() {
        // fieldSizeY = 3;
        // fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {                
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    private boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY; 
    }

    private boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

    private boolean checkWin(int c) {
        for (int i = 0; i < fieldSizeX; i++) {
            for (int j = 0; j < fieldSizeY; j++) {
                if (checkLine(i, j, 1, 0, winLength, c)) return true;
                if (checkLine(i, j, 1, 1, winLength, c)) return true;
                if (checkLine(i, j, 0, 1, winLength, c)) return true;
                if (checkLine(i, j, 1, -1, winLength, c)) return true;
            }
        }
        return false;
    }

    private boolean checkLine(int x, int y, int vx, int vy, int len, int c) {
        final int far_x = x + (len - 1) * vx;
        final int fsr_y = y + (len - 1) * vy;
        if (!isValidCell(far_x, fsr_y)) return false;
        for (int i = 0; i < len; i++) {
            if (field[y+i*vy][x+i*vx] != c) return false;
        }
        return true;
    }

    private boolean isFieldFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;                    
                }                
            }            
        }
        return true;
    }

    
    Field(){
        // setBackground(Color.WHITE);
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e){
                update(e);
            }
        });
        isInitialized = false;
    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;\nWin Length: %d", mode, fSzX, fSzY, wLen);
        fieldSizeX = fSzX;
        fieldSizeY = fSzY;
        winLength = wLen;
        initField();
        isGameOver = false;
        isInitialized = true;
        repaint();
    }

    private void render(Graphics g){
        if (!isInitialized) return;
        panelWidth = getWidth();
        panelHeight = getHeight();
        cellWidth = panelWidth/fieldSizeX;
        cellHeight = panelHeight/fieldSizeY;
        
        g.setColor(Color.BLACK);
        for (int h = 0; h < fieldSizeY; h++) {
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);            
        }
        for (int w = 0; w < fieldSizeX; w++) {
            int x = w * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {                
                if (field[y][x] == EMPTY_DOT) continue;
                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x*cellWidth + DOT_PADDING, y*cellHeight + DOT_PADDING, cellWidth - DOT_PADDING*2, cellHeight - DOT_PADDING*2);
                    // g.setColor(getBackground());
                    // g.fillOval(x*cellWidth + DOT_PADDING*4, y*cellHeight + DOT_PADDING*4, cellWidth - DOT_PADDING*8, cellHeight - DOT_PADDING*8);

                } else if (field[y][x] == AI_DOT) {
                    g.setColor(new Color(0xff0000));
                    g.fillOval(x*cellWidth + DOT_PADDING, y*cellHeight + DOT_PADDING, cellWidth - DOT_PADDING*2, cellHeight - DOT_PADDING*2);
                } else {
                    throw new RuntimeException("Unexpected value" + field[y][x] + " in cell: x=" + x + " y=" + y);
                }
            }
        }

        if (isGameOver) showMessageGameOver(g);
        // repaint();
    }

    private void update(MouseEvent e){
        if (isGameOver || !isInitialized) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeight;
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return;
        field[cellY][cellX] = HUMAN_DOT;
        if (checkEndGame(HUMAN_DOT, STATE_WIN_HUMAN)) return;
        aiTurn();
        // System.out.printf("x=%d, y=%d\n", cellX, cellY);
        repaint();
        if (checkEndGame(AI_DOT, STATE_WIN_AI)) return;
    }

    private boolean checkEndGame(int dot, int gameOverType) {
        if (checkWin(dot)) {
            this.gameOverType = gameOverType;
            isGameOver = true;
            repaint();
            return true;            
        }
        if (isFieldFull()) {
            this.gameOverType = STATE_DRAW;
            isGameOver = true;
            repaint();
            return true;
        }
        return false;
    }

    private void showMessageGameOver(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Times new roman", Font.BOLD, 48));
        switch (gameOverType) {
            case STATE_DRAW:
                g.drawString(MSG_DRAW, 180, getHeight()/2);
                break;
            case STATE_WIN_AI:
                g.drawString(MSG_WIN_AI, 20, getHeight()/2);
                break;
            case STATE_WIN_HUMAN:
                g.drawString(MSG_WIN_HUMAN, 70, getHeight()/2);
                break;
            default:
                throw new RuntimeException("Unexpected gameOver state: " + gameOverType);
        }
    }
    

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        render(g);
    }

    
}
