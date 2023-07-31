package dzh.com.JavaSE.com.IO.FileIO.convert;

import java.io.UnsupportedEncodingException;

/**
 * 字节数不完整会乱码
 * 编码解码格式不一样会乱码
 */
public class Convert1 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="我是程序员";
        //编码
        byte[] bytes = str.getBytes("utf-8");
        //解码
        String s=new String(bytes,"utf-8");
        System.out.println(s);
    }
}
