package com.sam.net.demo1;

import java.io.IOException;
import java.net.*;

/**
 * Created by SamZhao on 2017/5/30.
 * <p>
 * 实现UDP协议的发送端：
 * 实现封装数据的类 DatagramPacket   将数据包装起来
 * 实现数据传输的类 DatagramSocket   将数据包发出去
 * <p>
 * 实现步骤
 * 1、创建DatagramPacket对象，封装数据、接收端地址（IP和端口）
 * 2、创建创建DatagramSocket对象
 * 3、调用DatagramSocket方法send，发送数据包
 * 4、关闭资源  DatagramSocket
 * <p>
 * DatagramPacket构造方法：
 * DatagramPacket(byte[] buf, int length, InetAddress address, int port)    构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号。
 * <p>
 * DatagramSocket构造方法：
 */
public class UDPSend {

    public static void main(String[] args) {
        try {
            //创建数据包对象，封装要发送的数据，接收端IP，端口
            byte[] data = "你好UDP".getBytes();
            //创建一个InetAddress对象封装自己的IP
            InetAddress address = InetAddress.getByName("127.0.0.1");

            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, address, 6000);

            //创建DatagramSocket 对象
            DatagramSocket datagramSocket = new DatagramSocket();
            //调用方法send发送数据
            datagramSocket.send(datagramPacket);

            datagramSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
