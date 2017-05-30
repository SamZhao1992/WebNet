package com.sam.net.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP协议的服务端
 * ServerSocket
 *  构造方法SocketServer(port)  传递端口号
 *
 *
 *  重要：必须要获得客户端套接字对象Socket
 *      Socket accept
 */
public class TCPServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            //调用服务器套接字对象中的accept方法 获取客户端套接字对象
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            //通过客户端套接字对象 socket获取 字节输入流 读取的是客户端传过来的数据
            InputStream inputStream = socket.getInputStream();

            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("收到，谢谢".getBytes());

            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
