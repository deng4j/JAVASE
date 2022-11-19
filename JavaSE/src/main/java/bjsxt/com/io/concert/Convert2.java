package bjsxt.com.io.concert;

import java.io.*;

/**
 * 转换流：字节转字符
 * 输入流：InputStreamReader
 * 输出流：OutputStreamReader
 */

public class Convert2 {
    public static void main(String[] args) throws IOException {
        //指定解码字符集
        File file=new File("D:/idea/bjsxt/src/com/io/file/a.txt");
        //写入文件
        BufferedWriter bw=null;
        bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
        String str="北风卷地白草折，互舔启月夫妇";
        bw.write(str);
        bw.flush();
        bw.close();
        //读文件
        BufferedReader br=null;
        try {
             br=new BufferedReader(
                    new InputStreamReader(
                    new FileInputStream(file),"utf-8"
            ));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String info=null;
        while (null!=(info=br.readLine())){
            System.out.println(info);
        }
        br.close();
    }
}
