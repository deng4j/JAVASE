package dzh.com.JavaSE.com.IO.FileIO.ObjectIO;


import lombok.Data;

import java.io.*;
import java.nio.ByteBuffer;

@Data
class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;

    public byte[] BinaryCodeC(){
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        byte[] nameBytes = this.name.getBytes();
        buffer.putInt(nameBytes.length);
        buffer.put(nameBytes);
        buffer.flip();
        nameBytes=null;
        byte[] result = new byte[buffer.remaining()];
        buffer.get(result);
        return result;
    }
}

/**
 * 案例中可以看到，采用jdk序列化机制编码后的二进制数组大小竟然是二进制编码的数倍，占内存非常大
 */
public class ObjectIO3 {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        Student student = new Student();
        student.setName("hhhh");

        ObjectOutputStream os = new ObjectOutputStream(bos);
        os.writeObject(student);
        os.flush();
        os.close();

        System.out.println("jdk serializable length:"+bos.toByteArray().length);
        System.out.println("binary serializable length:"+student.BinaryCodeC().length);
    }
}
