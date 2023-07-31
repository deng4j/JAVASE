package dzh.com.JavaSE.com.IO.AIO.AIO_net.TimeDemo.serverHandler;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * 通过AcceptCompletionHandler实例作为handler来接收通知消息
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {
    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        /**
         * 再次调用accept()方法的原因：如果有新的客户端连接，系统将回调我们传入的CompletionHandler实例的
         * completed()方法，表示新的客户端已经接入成功。因为一个AsynchronousServerSocketChannel可以
         * 接入成千上万个客户端，所以需要继续调用它的accept()方法，异步接收其他客户端连接。
         */
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer,buffer,new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
