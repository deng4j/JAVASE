package bjsxt.com.io.concert;

import java.io.UnsupportedEncodingException;

/**
 * 编码和解码字符集不一样会出现乱码
 * 电脑默认的GBK
 * 字节缺少，长度丢失
 */
public class Convert1 {
    public static void main(String[] args) {
        String str="中国";
        byte[] bytes = str.getBytes();
        System.out.println(new String(bytes));
        //设定编码字符集
        try {
            bytes=str.getBytes("utf-8");
            System.out.println(new String(bytes));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //编码
        try {
            bytes="中国".getBytes("utf-8");
         //解码
         str=new String(bytes,"utf-8");
            System.out.println(str);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
