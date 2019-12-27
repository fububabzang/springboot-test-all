package com.realme.netty.nioTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * @program: springboot-test-all
 * @description:
 * @author: realme
 * @create: 2019-12-27 18:21
 **/
public class NIOFileTransferFrom {

    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream("D:\\test\\profile\\1.jpg");

        FileOutputStream fileOutputStream = new FileOutputStream("D:\\test\\profile\\2.jpg");

        FileChannel channelInput = fileInputStream.getChannel();
        FileChannel channelOutput = fileOutputStream.getChannel();
        channelOutput.transferFrom(channelInput, 0, channelInput.size());

        channelInput.close();
        channelOutput.close();

        fileInputStream.close();
        fileOutputStream.close();


    }
}
