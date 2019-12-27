package com.realme.netty.nioTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: springboot-test-all
 * @description:
 * @author: realme
 * @create: 2019-12-27 18:02
 **/
public class NIOFlieReadAndWrite {

    public static void main(String[] args) throws Exception {

        File file = new File("1.txt");

        FileInputStream fileInputStream = new FileInputStream(file);

        FileChannel fileChannelInput = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("2.txt");

        FileChannel fileChannelOutput = fileOutputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate((int) file.length());

        while (true) {
            byteBuffer.clear();
            int read = fileChannelInput.read(byteBuffer);
            if (read == -1) {
                break;
            }
            byteBuffer.flip();
            fileChannelOutput.write(byteBuffer);
        }

        fileOutputStream.close();
        fileChannelInput.close();


    }
}
