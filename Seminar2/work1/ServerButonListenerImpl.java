package Seminar2.work1;

public class ServerButonListenerImpl implements SocketThreadListener {

    @Override
    public void pressBtn(String btnName) {
        System.out.println("Server log: cmd received " + btnName);
    }
    
}
