package com.sam.net.demo1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by SamZhao on 2017/5/30.
 *
 * 实现UDP协议的接收端
 *
 *  实现封装数据的类 DatagramPacket   将数据接收
 *  实现数据传输的类 DatagramSocket   接收数据包
 *
 * 实现步骤：
 *  1、创建    DatagramSocket  对象，绑定端口 要和发送端请求端口号一致
 *  2、创建字节数组用于接收数据
 *  3、创建数据包对象   DatagramPacket
 *  4、调用    DatagramSocket  对象方法 receive(DatagramPacket)接受数据，数据放在数据包中
 *  5、拆包
 *      发送的IP地址
 *          数据包对象DatagramPacket方法getAddress()
 *      接收到的字节个数
 *          数据包对象DatagramPacket方法getLength()
 *      发送端的端口号
 *  6、关闭资源
 *
 */
public class UDPReceive {

    public static void main(String[] args) {
        try {
            //创建数据包传输对象 绑定端口号
            DatagramSocket datagramSocket = new DatagramSocket(6000);
            //创建字节数组
            byte[] bytes = new byte[1024*64];
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
            datagramSocket.close();

            System.out.println(new String(bytes, 0, length) + "..." + inetAddress.getHostAddress() + "..." + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
