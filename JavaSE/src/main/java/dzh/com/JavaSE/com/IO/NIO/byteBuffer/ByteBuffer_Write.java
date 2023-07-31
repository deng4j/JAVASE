package dzh.com.JavaSE.com.IO.NIO.byteBuffer;

import dzh.com.JavaSE.com.IO.NIO.utils.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;


/**
 *向 buffer 写入数据:
 * 1.调用 channel 的 read 方法: int readBytes = channel.read(buf);
 * 2.调用 buffer 自己的 put 方法: buf.put((byte)127);
 *
 * 调用 clear() 或 compact() 切换至写模式
 *
 * 强制写入：操作系统出于性能的考虑，会将数据缓存，不是立刻写入磁盘。可以调用 force(true)  方法将文件内容和元数据（文件的权限等信息）立刻写入磁盘
 */
@Slf4j
public class ByteBuffer_Write {

    public static void main(String[] args) {
        //使用 allocate 方法为 ByteBuffer 分配空间
        ByteBuffer buffer = ByteBuffer.allocate(10);
        byte b1=0x61;
        buffer.put(b1);
        byte[] bArr={0x62,0x63,0x64,0x65};
        buffer.put(bArr);

        //使用调试类
        ByteBufferUtil.debugAll(buffer);
        //这时候读数据，是读不到数据的，因为position现在是5，也就是0x65后面一位
        log.info("不切读模式直接读：{}",buffer.get());
        //不切换读模式直接读是会出出错
        ByteBufferUtil.debugAll(buffer);
        //切换到读模式
        buffer.flip();
        log.info("切读模式读到的十进制：{}",buffer.get());
        ByteBufferUtil.debugAll(buffer);

        //切换到写的压缩模式
        log.info("切换到写的压缩模式");
        buffer.compact();
        ByteBufferUtil.debugAll(buffer);

        //写一个数据
        log.info("切换到写的压缩模式后写数据");
        buffer.put(new byte[]{0x66,0x67});
        ByteBufferUtil.debugAll(buffer);
    }
}
