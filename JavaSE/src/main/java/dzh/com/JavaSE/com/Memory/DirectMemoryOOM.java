package dzh.com.JavaSE.com.Memory;

import dzh.com.JavaSE.com.Memory.OutOfMemoryError.HeapOOM;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {

        List<ByteBuffer> buffers = new ArrayList<>();
        while (true) {
            ByteBuffer buffer = ByteBuffer.allocateDirect(_1MB);
            buffers.add(buffer);
        }

    }
}