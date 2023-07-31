package dzh.com.JavaSE.com.IO.NIO.fileChannel;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * FileChannel 只能工作在阻塞模式下。
 * 不能直接打开 FileChannel，必须通过 FileInputStream、FileOutputStream 或者 RandomAccessFile 来获取 FileChannel，它们都有 getChannel 方法。
 *  - 通过 FileInputStream 获取的 channel 只能读
 *  - 通过 FileOutputStream 获取的 channel 只能写
 *  - 通过 RandomAccessFile 是否能读写根据构造 RandomAccessFile 时的读写模式决定
 *
 * channel 必须关闭，不过调用了 FileInputStream、FileOutputStream 或者 RandomAccessFile 的 close 方法会间接地调用 channel 的 close 方法
 */
@Slf4j
public class FileChannel0 {
    public static void main(String[] args) {
        try (RandomAccessFile file = new RandomAccessFile("/Users/deng4j/development/idea_project/project1/dzh.com.JavaSE/src/main/resources/nio/data1.txt", "rw")) {
            FileChannel channel = file.getChannel();

            //获取当前位置，还可以改变位置
            System.out.println("position："+channel.position());
            System.out.println("文件seize："+channel.size());

            ByteBuffer buffer = ByteBuffer.allocate(10);
            do {
                // 向 buffer 写入
                int len = channel.read(buffer);
                log.debug("读到字节数：{}", len);
                if (len == -1) {
                    break;
                }
                // 切换 buffer 读模式
                buffer.flip();
                while(buffer.hasRemaining()) {
                    log.debug("{}", (char)buffer.get());
                }
                // 切换 buffer 写模式
                buffer.clear();
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}