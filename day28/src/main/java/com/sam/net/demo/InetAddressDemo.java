package com.sam.net.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 表示互联网中的IP地址
 * <p>
 * 静态方法
 *   getLocalHost()   LocalHost   本地主机
 *   返回本地主机 返回表示回送地址的 InetAddress
 */
public class InetAddressDemo {
    public static void main(String[] args) {

        try {
            System.out.println("Hello InetAddressDemo...");
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress);

            InetAddress local = InetAddress.getLocalHost();
            InetAddress remote = InetAddress.getByName("www.mmbao.com");
            System.out.println("本机的IP地址：" + local.getHostAddress());
            System.out.println("itcast的IP地址：" + remote.getHostAddress());
            System.out.println("itcast的主机名为：" + remote.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
