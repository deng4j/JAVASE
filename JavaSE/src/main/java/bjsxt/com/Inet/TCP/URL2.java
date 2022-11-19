package bjsxt.com.Inet.TCP;

import java.io.*;
import java.net.URL;

public class URL2 {
    public static void main(String[] args) throws IOException {
        //主页默认资源
        URL url=new URL("http://www.baidu.com");
        //获取资源网络流
        InputStream is=url.openStream();
        BufferedReader br=new BufferedReader(new InputStreamReader(is,"utf-8"));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("D:/idea/bjsxt/src/com/io/file/parent/baidu.html"),"utf-8"
        ));
        String s =null;
        while (null!=(s=br.readLine())){
            bw.write(s);
        }
        bw.flush();
        bw.close();
        is.close();
    }
}
