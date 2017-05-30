package com.sam.net.demo3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 实现TCP客户端 连接到服务器
 * 和服务器实现数据交换
 * 实现TCP客户端程序的类
 */
public class TCPClient {
    public static void main(String[] args) {
        try {
            //创建socket对象 连接服务器
            Socket socket = new Socket("127.0.0.1", 8888);
            //通过客户端的套接字对象Socket方法，获取字节输出流，将数据写向服务器
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("服务器OK".getBytes());

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);

            System.out.println(new String(bytes,0, len));

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
