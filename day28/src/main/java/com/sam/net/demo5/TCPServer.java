package com.sam.net.demo5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by SamZhao on 2017/5/30.
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true){
                //获取到一个 必须开启一个新线程
                Socket socket = serverSocket.accept();
                new Thread(new Upload(socket)).start();
            }
//            socket.close();
//            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
