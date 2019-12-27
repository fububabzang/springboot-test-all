package com.realme.netty.nioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: springboot-test-all
 * @description:
 * @author: realme
 * @create: 2019-12-27 17:39
 **/
public class NIOFileReadChannel {

    public static void main(String[] args) throws Exception {

        File file = new File("D:\\test\\file01.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        channel.read(byteBuffer);

        System.out.println(new String(byteBuffer.array()));

        channel.close();
        fileInputStream.close();
    }
}
