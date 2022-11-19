package bjsxt.com.io.byteArray;

import java.io.*;

public class demo1 {
    public static void main(String[] args) {
        try {
            byte[] bis= Write();
            Read(bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Read(byte[] bis) throws IOException {
        InputStream is=new BufferedInputStream(new ByteArrayInputStream(bis));
        //中间容器
        byte[] bytes=new byte[1024];
        int len=0;
        while (-1!=(len=is.read(bytes))){
            String s = new String(bytes, 0, len);
            System.out.println(s);
        }
        is.close();
    }

    private static byte[] Write() throws IOException {
        //，目的地
        byte[] dest=null;
        //选择流
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        //操作写入
        String msg="垂死病中惊坐起，暗风吹雨入寒窗";
        byte[] info = msg.getBytes();
        bos.write(info,0,info.length);
        dest=bos.toByteArray();
        bos.close();
        return dest;
    }
}
