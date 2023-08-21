package dzh.com.JavaSE.com.system;

/**
 * 当你开代理时，有可能idea工具会走代理，而程序不走代理
 *
 * http代理： -DproxyHost=127.0.0.1 -DproxyPort=19180
 * socks代理： -DsocksProxyHost=127.0.0.1 -DsocksProxyPort=19181
 */
public class SystemProxy {
    public static void main(String[] args) {
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", "127.0.0.1");
        System.setProperty("http.proxyPort", "19180");
    }
}
