package com.realme.netty.bioTest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program: springboot-test-all
 * @description:
 * @author: realme
 * @create: 2019-12-27 14:32
 **/
public class BIOServer {

    public static void main(String[] args) throws Exception {
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();

        ServerSocket serverSocket = new ServerSocket(6666);

        System.out.println("服务器启动了");


        while (true) {

            System.out.println("线程的信息是: id=" + Thread.currentThread().getId() + "名字:" + Thread.currentThread().getName());

            System.out.println("等待连接---------");

            final Socket socket = serverSocket.accept();

            System.out.println("连接到一个客户端");

            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        handler(socket);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    public static void handler(Socket socket) throws Exception {
        try {
            System.out.println("线程的信息是: id=" + Thread.currentThread().getId() + "名字:" + Thread.currentThread().getName());
            byte[] bytes = new byte[1024];

            InputStream inputStream = socket.getInputStream();
            while (true) {
                System.out.println("线程的信息是: id=" + Thread.currentThread().getId() + "名字:" + Thread.currentThread().getName());
                
                int read = inputStream.read(bytes);

                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
