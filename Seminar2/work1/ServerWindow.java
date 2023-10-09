package Seminar2.work1;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ServerWindow extends JFrame {

    // private final ChatServer chatServer;
    private final SocketThreadListener chatListener;

    private static final int POS_X = 500;
    private static final int POS_Y = 550;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JButton btnStart = new JButton("Start");
    private final JButton btnStop = new JButton("Stop");
    private final JTextArea log = new JTextArea();

    private ServerWindow(ChatServer chatServer, SocketThreadListener socketThreadListener) {
        this.chatListener = socketThreadListener;     
        // this.chatServer = chatServer;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat Server");
        setAlwaysOnTop(true);
        setLayout(new GridLayout(1,2));
        add(btnStart);
        add(btnStop);

        setVisible(true);

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatListener.pressBtn("btnStop");
                chatServer.stop();
                // System.out.println("Server stoped " + isServerWorking + "\n");
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                chatListener.pressBtn("btnStart");   
                chatServer.start();            
                // System.out.println("Server started " + isServerWorking + "\n");
            }
        });
    }

    public static void main(String[] args) {
        ServerSocketThreadListener serverSocketThreadListener = new ServerSocketImpl();
        SocketThreadListener serverBtnList = new ServerButonListenerImpl();
        SocketThreadListener socketThreadListener = new ClientListenerImpl();
        ChatServer server = new ChatServer(false, serverSocketThreadListener, serverBtnList);
        new ServerWindow(server, socketThreadListener);
    }
}
