package com.sam.net.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * 实现一个UDP发送  键盘输入形式
 *
 * 输入完毕 发送给接收端
 *
 *
 */
public class UDPSend {

    public static void main(String[] args) {
        try {
            //创建DatagramSocket 对象
            DatagramSocket datagramSocket = new DatagramSocket();
            //创建一个InetAddress对象封装自己的IP
            InetAddress address = InetAddress.getByName("127.0.0.1");

            Scanner scanner = new Scanner(System.in);
            while(true){
                String msg = scanner.nextLine();

                //创建数据包对象，封装要发送的数据，接收端IP，端口
                byte[] data = msg.getBytes();

                DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, 6000);

                //调用方法send发送数据
                datagramSocket.send(datagramPacket);
            }

//            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
