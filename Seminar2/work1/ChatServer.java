package Seminar2.work1;

public class ChatServer {
    private boolean isServerWorking;
    private final ServerListener serverListener;
    private final ServerSocketThreadListener serverSocketThreadListener;
    private final SocketThreadListener socketThreadListener;

    ChatServer(boolean isServerWorking, ServerSocketThreadListener serverSocketThreadListener, SocketThreadListener socketThreadListener) {
        this.isServerWorking = isServerWorking;
        this.serverListener = new ServerListener() {
            @Override
            public void onMessageRecived(String message) {
                System.out.println("Message: " + message);
            }            
        };
        this.serverSocketThreadListener = serverSocketThreadListener;
        this.socketThreadListener = socketThreadListener;        
    }

    public void start () {
        socketThreadListener.pressBtn("btnStart");
        if (isServerWorking) {
            // System.out.println("Server already started");
            serverListener.onMessageRecived("Server already started");
        } else {
            // System.out.println("Server started");
            serverSocketThreadListener.onStart();
            isServerWorking = true;
            serverListener.onMessageRecived("Server started");
        }
    }

        public void stop () {
            socketThreadListener.pressBtn("btnStop");
        if (!isServerWorking) {
            // System.out.println("Server already stoped");
            serverListener.onMessageRecived("Server already stoped");
        } else {
            // System.out.println("Server stoped");
            serverSocketThreadListener.onStop();
            isServerWorking = false;
            serverListener.onMessageRecived("Server stoped");
        }
    }


}

interface ServerListener {
    void onMessageRecived(String message);
}

interface ServerSocketThreadListener {
    void onStart();
    void onStop();
}

interface SocketThreadListener {
    void pressBtn(String btnName);
}