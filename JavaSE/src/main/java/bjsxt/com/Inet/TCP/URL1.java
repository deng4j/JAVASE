package bjsxt.com.Inet.TCP;

import java.net.MalformedURLException;
import java.net.URL;

public class URL1 {
    public static void main(String[] args) throws MalformedURLException {
        //构建绝对路径
        URL url=new URL("http://www.baidu.com:80/index.html?id=12");
        System.out.println("协议："+url.getProtocol());
        System.out.println("域名："+url.getHost());
        System.out.println("端口："+url.getPort());
        System.out.println("资源："+url.getFile());
        System.out.println("锚点："+url.getRef());
        //？参数：存在锚点返回null，不存在返回正确参数
        System.out.println("参数："+url.getQuery());
        //相对路径
        url=new URL("http://www.baidu.com:80/a/");
        url=new URL(url,"b.txt");
        System.out.println(url);
    }
}
