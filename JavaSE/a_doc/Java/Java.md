# 程序代理配置

当你开代理时，有可能idea工具会走代理，而程序不走代理

1.设置系统参数

```java
System.setProperty("http.proxySet", "true");
System.setProperty("http.proxyHost", "127.0.0.1");
System.setProperty("http.proxyPort", "19180");  
```

2.VM options设置

```shell
http代理： -DproxyHost=127.0.0.1 -DproxyPort=19180
socks代理： -DsocksProxyHost=127.0.0.1 -DsocksProxyPort=19181
```

