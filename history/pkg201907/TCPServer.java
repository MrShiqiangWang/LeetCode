package history.pkg201907;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(final String[] args) {
        setUpTcpServer(9999);
    }

    public static void setUpTcpServer(final int port) {
        try {
            @SuppressWarnings("resource")
            final ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器正常启动。。。。");
            Socket s = null;
            while ((s = serverSocket.accept()) != null) {
                System.out.println("连接成功" + s.getRemoteSocketAddress());
            } // 阻塞方法

        }
        catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
