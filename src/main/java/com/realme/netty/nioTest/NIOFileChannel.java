package com.realme.netty.nioTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @program: springboot-test-all
 * @description:
 * @author: realme
 * @create: 2019-12-27 17:15
 **/
public class NIOFileChannel {

    public static void main(String[] args) throws Exception {

        String str = "realme,李超aaa";

        File file = new File("D:\\test\\file01.txt");
        //创建输出流
         FileOutputStream fileOutputStream = new FileOutputStream(file);

         //从输出流中获取channel
         FileChannel channel = fileOutputStream.getChannel();

         //创建缓冲区 缓冲区的大小在不浪费的情况下可以设置为  字节数的长度
        ByteBuffer byteBuffer = ByteBuffer.allocate(str.getBytes().length);

        //将str放进缓冲区
        byteBuffer.put(str.getBytes());

        //对 byteBuffer 进行flip
        byteBuffer.flip();

        //将byteBuffer中的数据写入channel
        channel.write(byteBuffer);
        channel.close();
        fileOutputStream.close();
    }
}
