package JavaSE.com.Net.demo.TCP;

import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * 封装端口：在InetAdress基础上+端口
 */
public class socket {
    public static void main(String[] args) {
        InetSocketAddress address=new InetSocketAddress("localhost",9999);
        System.out.println(address.getHostName());
        System.out.println(address.getPort());

        InetAddress addr = address.getAddress();
        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());
    }
}
