package com.sam.net.demo5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by SamZhao on 2017/5/30.
 */
public class Upload implements Runnable {

    Socket socket;

    public Upload(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);

            File file = new File("d://upload");
            if(!file.exists())
                file.mkdirs();

            //防止文件同名被覆盖,从新定义文件名字
            //规则:  域名+毫秒值+6位随机数
            String filename="itcast"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
            //创建字节输出流,将图片写入到目的文件夹中
            FileOutputStream fos = new FileOutputStream(file + File.separator+filename);

            while ((len = inputStream.read(bytes))!= -1){
                fos.write(bytes, 0, len);
            }

            socket.getOutputStream().write("上传成功".getBytes());

            fos.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
