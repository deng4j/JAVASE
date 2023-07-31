package dzh.com.JavaSE.com.IO.NIO.byteBuffer;

import dzh.com.JavaSE.com.IO.NIO.utils.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;


/**
 *从 buffer 读取数据:
 * 1.调用 channel 的 write 方法: int writeBytes = channel.write(buf);
 * 2.调用 buffer 自己的 get 方法:
 *      get 方法会让 position 读指针向后走，如果想重复读取数据
 *          (1)可以调用 rewind 方法将 position 重新置为 0
 *          (2)或者调用 get(int i) 方法获取索引 i 的内容，它不会移动读指针
 *
 * 3.mark 和 reset：
 * （1）mark 是在读取时，做一个标记，即使 position 改变，只要调用 reset 就能回到 mark 的位置
 * （2）rewind 和 flip 都会清除 mark 位置
 */
@Slf4j
public class ByteBuffer_Read {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});

        buffer.flip(); //切换至读模式

        buffer.get(new byte[4]);
        log.info("读4个字节：");
        ByteBufferUtil.debugAll(buffer);

        log.info("调用rewind()重置方法：");
        buffer.rewind();
        ByteBufferUtil.debugAll(buffer);

        //mark & reset
        buffer.get(new byte[2]);
        ByteBufferUtil.debugAll(buffer);
        log.info("标记索引2位置：");
        buffer.mark();
        buffer.get(new byte[2]);
        ByteBufferUtil.debugAll(buffer);
        log.info("重置到索引2位置：");
        buffer.reset();
        ByteBufferUtil.debugAll(buffer);

        //获取索引位置字符
        log.info("获取索引位置字节：{}",buffer.get(1));
    }
}
