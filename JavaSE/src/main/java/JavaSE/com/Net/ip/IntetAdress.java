package JavaSE.com.Net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IntetAdress {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address=InetAddress.getLocalHost();
        String hostAddress = address.getHostAddress();
        String hostName = address.getHostName();
        System.out.println(hostAddress);
        System.out.println(hostName);
        //
        InetAddress add=InetAddress.getByName("www.baidu.com");
        String baiduAdd = add.getHostAddress();
        System.out.println(baiduAdd);
    }
}
