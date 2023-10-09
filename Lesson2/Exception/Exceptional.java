package Exception;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Exceptional extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler {
    private Exceptional() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(1100, 200, 500, 300);
        Thread.setDefaultUncaughtExceptionHandler(this);
        JButton btn = new JButton("Push me");
        btn.addActionListener(this);
        add(btn);
        setVisible(true);
    }

    public static void main(String[] args) {
        // new Exceptional();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Exceptional();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new ArrayIndexOutOfBoundsException("Bad thing happened!");
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Exception!", JOptionPane.ERROR_MESSAGE);
    }
}
