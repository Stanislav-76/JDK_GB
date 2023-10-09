package Seminar2.work1;

public class ServerSocketImpl  implements ServerSocketThreadListener {

    @Override
    public void onStart() {
        System.out.println("Log: server started");
    }

    @Override
    public void onStop() {
        System.out.println("Log: server stoped");
    }
    
}
