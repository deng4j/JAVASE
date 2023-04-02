package JavaSE.com.Net.demo.TCP;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getLocalHost();
        String ip = address.getHostAddress();
        String hostName = address.getHostName();
        System.out.println("获取本机ip:"+ip);
        System.out.println("获取本机名:"+hostName);

        //根据域名得到InetAdress对象
        address=InetAddress.getByName("www.baidu.com");
        System.out.println("根据域名得到ip："+address.getHostAddress());
        System.out.println("根据域名得到域名"+address.getHostName());

        //根据ip得到InetAdress对象
        address=InetAddress.getByName("112.80.248.76");
        System.out.println("根据ip得到ip："+address.getHostAddress());
        //域名不存在或不允许解析返回ip
        System.out.println("根据ip得到ip："+address.getHostName());

    }
}
