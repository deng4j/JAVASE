package dzh.com.JavaSE.com.IO.NIO.SocketChannel.demo.nio6_TimeDemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class MultiplexerTimeClientHandle implements Runnable{
    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public MultiplexerTimeClientHandle(String host, int port) {
        this.host = host!=null?host:"localhost";
        this.port=port;
        try {
            this.selector=Selector.open();
            this.socketChannel=SocketChannel.open();
            this.socketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!stop){
            try {
                selector.select(1000);
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
                            if (key.channel()!=null){
                                key.channel().close();
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        if (selector!=null){
            try {
                selector.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleInput(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel sc = (SocketChannel)key.channel();
            if (key.isConnectable()){
                if (socketChannel.finishConnect()){
                    sc.register(this.selector,SelectionKey.OP_READ);
                    doWrite(sc);
                }else {
                    System.exit(1);
                }
            }

            if (key.isReadable()){
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes>0){
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("Now is :" + body);
                    this.stop=true;
                }else if (readBytes<0){
                    //关闭链路
                    key.cancel();
                    sc.close();
                }else {
                    //读到0字节，忽略
                }
            }
        }
    }

    private void doConnect() throws IOException {
        /**
         * 判断是否连接成功，如果连接成功，则直接注册读状态位到多路复用器中，
         * 如果连接失败（异步连接，返回false，说明客户端已经发送sync包，服务端没有返回ack，物理链路未建立）
         */
        if (this.socketChannel.connect(new InetSocketAddress(this.host,this.port))) {
            this.socketChannel.register(this.selector, SelectionKey.OP_READ);
            doWrite(this.socketChannel);
        }else {
            this.socketChannel.register(this.selector, SelectionKey.OP_CONNECT);
        }
    }

    private void doWrite(SocketChannel socketChannel) throws IOException {
        byte[] req = "query time order".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        socketChannel.write(writeBuffer);
        if (!writeBuffer.hasRemaining()){
            System.out.println("send order 2 server succeed.");
        }
    }
}
