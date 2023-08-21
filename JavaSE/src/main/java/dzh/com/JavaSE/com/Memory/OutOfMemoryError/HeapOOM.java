package dzh.com.JavaSE.com.Memory.OutOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError  -XX:HeapDumpPath=/Users/deng4j/Downloads/packages/jvm.dump
 *
 * 限制Java堆的大小为20MB，不可扩展（将堆的最小值-Xms参数与最大值-Xmx参数设置为一样即可避免堆自动扩展），
 * 通过参数-XX：+HeapDumpOnOutOf-MemoryError可以让虚拟机在出现内存溢出异常的时候Dump出当前的内存堆转储快照以便进行事后分析。
 */
public class HeapOOM {
    public static void main(String[] args) {
        List<HeapOOM> list =new ArrayList<>();
        while (true){
            list.add(new HeapOOM());
        }
    }
}
