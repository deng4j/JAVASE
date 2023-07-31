package dzh.com.JavaSE.com.IO.NIO.byteBuffer;

import dzh.com.JavaSE.com.IO.NIO.utils.ByteBufferUtil;
import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;


@Slf4j
public class ByteBuffer_String {

    public static void main(String[] args) {
        //一.字符串转化为ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        log.info("字符串转化为ByteBuffer");
        byte[] strBytes = "hello".getBytes(StandardCharsets.UTF_8);
        buffer.put(strBytes);
        ByteBufferUtil.debugAll(buffer);

        //借助Charset字符集处理，会自动切换到读模式
        log.info("Charset字符集处理");
        ByteBuffer buffer1 = StandardCharsets.UTF_8.encode("love");
        ByteBufferUtil.debugAll(buffer1);

        //wrap方法，也会切换到读模式
        log.info("wrap方法");
        ByteBuffer buffer2 = ByteBuffer.wrap("你好".getBytes());
        ByteBufferUtil.debugAll(buffer2);

        //二.ByteBuffer转String，必须在读模式下才生效
        String str = StandardCharsets.UTF_8.decode(buffer2).toString();
        log.info("ByteBuffer转String:{}",str);
    }
}
