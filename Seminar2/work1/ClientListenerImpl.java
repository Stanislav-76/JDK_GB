package Seminar2.work1;

public class ClientListenerImpl implements SocketThreadListener {

    @Override
    public void pressBtn(String btnName) {
        System.out.println("Client log: pressed button " + btnName);
    }
    
}
