package JavaSE.com.IO.ReadWrite;

import JavaSE.com.IO.classloader.ClassLoaderTest;

import java.io.*;

/**
 * 字符流：字节流+编码表
 */
public class demo1 {
    public static void main(String[] args) throws IOException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();

        File file=new File(classPath+"io/folder/b/word.txt");

        write(file);
        read(file);
    }

    private static void write(File file) throws IOException {
        Writer w=new FileWriter(file);
        String str="五花马千金裘呼儿将出换美酒";
        w.write(str,0,6);
        w.append("---李白");
        w.flush();
        w.close();
    }

    private static void read(File file) throws IOException {
        Reader r=new FileReader(file);
        char[] chars=new char[1024];
        int len=0;
        while (-1!=(len=r.read(chars))){
            String str=new String(chars,0,len);
            System.out.println(str);
        }
        r.close();
    }
}
