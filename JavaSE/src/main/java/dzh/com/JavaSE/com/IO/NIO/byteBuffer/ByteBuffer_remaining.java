package dzh.com.JavaSE.com.IO.NIO.byteBuffer;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;


/**
 * remaining()返回此缓冲区中剩余的元素数
 */
@Slf4j
public class ByteBuffer_remaining {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});

        buffer.flip(); //切换至读模式

        System.out.println(buffer.remaining());
    }
}
