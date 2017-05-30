package com.sam.net.demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by SamZhao on 2017/5/30.
 *
 * 实现UDP协议的接收端
 *
 * 永不停歇的接收端
 *
 */
public class UDPReceive {

    public static void main(String[] args) {
        try {
            //创建数据包传输对象 绑定端口号
            DatagramSocket datagramSocket = new DatagramSocket(6000);
            //创建字节数组
            byte[] bytes = new byte[1024*64];
            while(true){
                //创建数据包对象  传递字节数组
                DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
                //调用datagramPacket receive接受数据
                datagramSocket.receive(datagramPacket);

                //获取发送端IP地址对象
                InetAddress inetAddress = datagramPacket.getAddress();

                //获取发送端口号
                int port = datagramPacket.getPort();

                //接收到字节个数
                int length = datagramPacket.getLength();
                System.out.println(new String(bytes, 0, length) + "..." + inetAddress.getHostAddress() + "..." + port);
            }

//            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
