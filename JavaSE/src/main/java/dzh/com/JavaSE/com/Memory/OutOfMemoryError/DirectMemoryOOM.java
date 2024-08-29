package dzh.com.JavaSE.com.Memory.OutOfMemoryError;


import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=1m
 *
 * Unsafe溢出时报：java.lang.OutOfMemoryError
 * -XX:MaxDirectMemorySize不起作用
 *
 * ByteBuffer溢出时报：java.lang.OutOfMemoryError：Direct buffer memory
 * -XX:MaxDirectMemorySize起作用
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        List<ByteBuffer> list =new ArrayList<>(); // 保持引用，防止垃圾回收
        while (true){
            ByteBuffer buffer = ByteBuffer.allocateDirect(_1MB);
            list.add(buffer);
        }
    }
}