package dzh.com.JavaSE.com.IO.AIO.AIO_net.TimeDemo.serverHandler;

import io.netty.util.internal.StringUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel channel;

    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        if (this.channel==null){
            this.channel=channel;
        }
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, "UTF-8");
            System.out.println("The time server receive order:"+body+"--"+Thread.currentThread().getName());
            String currentTime = "query time order".equalsIgnoreCase(req) ? new Date(System.currentTimeMillis()).toString() : "bad order";
            doWrite(currentTime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            channel.close();
        } catch (IOException e) {
            //ignore on close
        }
    }

    private void doWrite(String response) {
        if (!StringUtil.isNullOrEmpty(response)){
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    //没有发送完，继续发
                    if (attachment.hasRemaining()) {
                        channel.write(attachment,attachment,this);
                    }
                }
                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        //ignore on close
                    }
                }
            });
        }
    }
}
