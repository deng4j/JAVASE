package dzh.com.JavaSE.com.IO.NIO.fileChannel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class FileChannelTransfer {

    /**
     * 两个 Channel 传输数据
     */
    public static void main(String[] args) {
        try {
            FileChannel from = new FileInputStream("D:\\ideasX\\project2\\netty\\netty1_byteBuffer\\src\\main\\resources\\fileChannelRead.txt").getChannel();
            FileChannel to = new FileOutputStream("D:\\ideasX\\project2\\netty\\netty1_byteBuffer\\src\\main\\resources\\fileChannelWrite.txt").getChannel();

            long size= from.size();
            //left代表剩余多少字节
            for (long left = size; left >0 ; ) {
                //效率高，底层利用操作系统的零拷贝进行优化,一次2g数据
                long transferNum = from.transferTo((size-left), from.size(), to);
                left-=transferNum;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
