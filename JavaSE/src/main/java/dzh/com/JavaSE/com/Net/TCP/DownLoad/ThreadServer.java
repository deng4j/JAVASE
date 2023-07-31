package dzh.com.JavaSE.com.Net.TCP.DownLoad;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;

public class ThreadServer implements Runnable{
    private static final byte endflag=0x04;
    private Socket accept;

    public ThreadServer(Socket accept){
        this.accept=accept;
    }

    @Override
    public void run() {
        //创建一个hashmap<文件名，路径>
        HashMap<String,String> ServerMap=new HashMap<>();
        File file=new File("D:/idea/javas/src/com/Net/TCP/file");
        File[] files = file.listFiles();
        for (File f : files) {
            String[] split = f.toString().split("\\\\");
            String filename =split[split.length-1].replaceAll(" ","");
            String value=f.toString().trim();
            ServerMap.put(filename,value);
        }

        //发送文件名到客户端
        BufferedOutputStream bos= null;
        try {
            bos = new BufferedOutputStream(accept.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes=ServerMap.toString().replaceAll(" ","").getBytes();

        try {
            bos.write(bytes,0,bytes.length);
            //约定读到结尾
            bos.write(endflag);
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //判断是否包含文件
        BufferedInputStream bis= null;
        try {
            bis = new BufferedInputStream(accept.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] byflag=new byte[200];
        try {
            bis.read(byflag);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //非常注意，要去空，否则字符串长度为200
        String fileName=new String(byflag).trim();
        System.out.println(fileName);
        System.out.println(fileName.length());
        System.out.println(ServerMap);
        System.out.println(ServerMap.containsKey(fileName));
        //开始读文件
        if (ServerMap.containsKey(fileName)){
            File file1=new File(ServerMap.get(fileName));
            System.out.println(ServerMap.get(fileName));
            BufferedInputStream fbis= null;
            try {
                fbis = new BufferedInputStream(new FileInputStream(file1));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] filebyte=new byte[8192];
            int flen=0;
            try {
                while (-1!=(flen=fbis.read(filebyte))){
                    bos.write(filebyte,0,flen);
                    bos.flush();
                }
            } catch (IOException e) {
                if (null!=fbis){
                    try {
                        fbis.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            System.out.println("传输完毕");
        }else {
            System.out.println("传输失败");
        }
        try {
            accept.shutdownOutput();
            bis.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
