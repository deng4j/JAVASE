package dzh.com.JavaSE.com.IO.AIO.AIO_net.TimeDemo.clientHandler;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * A attachment：AsynchronousSocketChannel的附件，用于回调通知时作为入参被传递
 * CompletionHandler<Void?,super A> handler：异步操作回调通知接口，由调用者实现
 */
public class AsyncTimeClientHandler implements Runnable, CompletionHandler<Void,AsyncTimeClientHandler> {

    private AsynchronousSocketChannel client;
    private String host;
    private int port;
    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host=host;
        this.port=port;
        try {
            client=AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch=new CountDownLatch(1);
        client.connect(new InetSocketAddress(host,port),this,this);
        try {
            latch.await();
            client.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {
        byte[] req = "query time order".getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(req.length);
        writeBuffer.put(req);
        writeBuffer.flip();
        client.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if (attachment.hasRemaining()){ //没写完，继续写
                    client.write(attachment,attachment,this);
                }else { // 写完了
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte[] bytes = new byte[attachment.remaining()];
                            attachment.get(bytes);
                            String body;
                            try {
                                body=new String(bytes,"UTF-8");
                                System.out.println("Now is:"+body);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            try {
                                client.close();
                                latch.countDown();
                            } catch (IOException e) {
                                //ignore on close
                            }
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    client.close();
                    latch.countDown();
                } catch (IOException e) {
                    //ignore on close
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        try {
            client.close();
            latch.countDown();
        } catch (IOException e) {
            //ignore on close
        }
    }
}
