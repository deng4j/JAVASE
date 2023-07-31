package dzh.com.JavaSE.com.IO.NIO.SocketChannel.demo.nio6_TimeDemo;

import io.netty.util.internal.StringUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeServerHandler implements Runnable{

    private Selector selector;
    private ServerSocketChannel servChannel;
    private volatile boolean stop;

    public MultiplexerTimeServerHandler(int port) {
        try {
            this.selector = Selector.open();
            this.servChannel = ServerSocketChannel.open();
            servChannel.configureBlocking(false);//设为异步非阻塞模式
            servChannel.socket().bind(new InetSocketAddress(port),1024);
            servChannel.register(selector, SelectionKey.OP_ACCEPT);//监听SelectionKey.OP_ACCEPT操作位
            System.out.println("The Time Server is start in port："+port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void stop(){
        this.stop = true;
    }


    @Override
    public void run() {
        while (!stop){
            try {
                selector.select(1000);//隔1s休息一次
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeys.iterator();
                SelectionKey key = null;
                while (it.hasNext()){
                    key = it.next();
                    it.remove();
                    try {
                        handleInput(key);
                    } catch (IOException e) {
                        if (key!=null){
                            key.cancel();
                            if (key.channel()!=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //selector关闭后，所有注册在上面的channel和pipe等资源都会被自动注册并关闭
        if (selector!=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()){
            //处理新接入的请求消息
            if (key.isAcceptable()){
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                SocketChannel sc = ssc.accept();//接收客户端连接请求并创建SocketChannel实例
                sc.configureBlocking(false);
                sc.register(this.selector,SelectionKey.OP_READ);
            }
            // 处理读数据事件
            if (key.isReadable()){
                SocketChannel sc = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes>0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order:"+body+"--"+Thread.currentThread().getName());
                    String currentTime = "query time order".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "bad order";
                    doWrite(sc,currentTime);
                }else if (readBytes<0){
                    //对端链路关闭
                    key.cancel();
                    sc.close();
                }else {
                    //读到0字节，忽略
                }
            }
        }
    }

    private void doWrite(SocketChannel channel, String response) throws IOException {
        if (!StringUtil.isNullOrEmpty(response)){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
            if (!writeBuffer.hasRemaining()) {
                System.out.println("send order 2 server succeed");
            }
        }
    }


}
