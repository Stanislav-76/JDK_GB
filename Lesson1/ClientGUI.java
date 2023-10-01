package Lesson1;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ClientGUI extends JFrame{
    private static final int WIDTH =  400;
    private static final int HEIGHT =  300;

    private static boolean isAuthorize = false;
    private static final String path = "Lesson1/log.txt"; 
    
    private final JPanel panelTop = new JPanel(new GridLayout(2,3));
    private final JTextField tfIPAdress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("ivan_viktorovich");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");
    
    private final JPanel panelMid = new JPanel(new GridLayout(1,2));
    private final JTextArea log = new JTextArea();
    private final JList<String> listUser = new JList<>();

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    ClientGUI() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat client");

        panelTop.add(tfIPAdress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        String users[] = {"Dima", "Katya", "Sasha", "Vasya"}; 
        listUser.setListData(users);
        panelMid.add(scrollLog);
        panelMid.add(listUser);
        add(panelMid);

        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAuthorize == false) {
                    System.out.println("Авторизуйтесь");
                    return;
                }
                if (tfMessage.getText().length() > 0) {
                    log.append(tfMessage.getText() + "\n");
                    save(tfMessage.getText());
                }
            }
        });

        tfMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isAuthorize == false) {
                    System.out.println("Авторизуйтесь");
                    return;
                }                
                if (tfMessage.getText().length() > 0) {
                    log.append(tfMessage.getText() + "\n");
                    save(tfMessage.getText());
                }
            }
        });

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isAuthorize = true;
                log.setText(null);
                log.append(load());                
            }
        });



        setVisible(true);

    }
    
    private void save(String txt) {
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(txt + "\n");
        } catch (IOException e) {
            System.out.println("log не обновлен");;
        }
    }

    private String load() {
        String data = "";       
        try (FileReader fileReader = new FileReader(path)) {
            int c;
            while ((c=fileReader.read())!=-1) {
                data += (char)c;
            }
        } catch (IOException e) {
            System.out.println("log не найден");;
        }
        return data;
    }


    public static void main(String[] args) {
        new ClientGUI();
    }

}
