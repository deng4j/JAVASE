package JavaSE.com.Net.TCP.DownLoad;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端指定ip和端口
        Socket client=new Socket("localhost",10000);
        //读取服务器的数据
        BufferedInputStream bis=new BufferedInputStream(client.getInputStream());
        //写出给服务器
        BufferedOutputStream bos=new BufferedOutputStream(client.getOutputStream());
        String fileName = checkFile(bis);
        byte[] bytes=fileName.getBytes();
        bos.write(bytes,0,bytes.length);
        //注意刷新
        bos.flush();
        //拷贝文件
        File file=new File("D:/idea/javas/src/com/Net/TCP/file/"+UUID.randomUUID().toString()+".jpg");
        BufferedOutputStream fbos=new BufferedOutputStream(new FileOutputStream(file));
        byte[] byte1=new byte[8192];
        int len=0;
        while (-1!=(len=bis.read(byte1))){
            fbos.write(byte1,0,len);
            fbos.flush();
        }
        System.out.println("下载成功");

    }

    private static String checkFile(BufferedInputStream bis) throws IOException {
        //创建hashmap<String,String>接收数据
        HashMap<String,String> ClientMap=new HashMap<>();
        //展示服务器的文件
        byte[] bytes=new byte[1024];
        int len=0;
        StringBuilder fileName=new StringBuilder();
        //这个容易阻塞
        while (-1!=(len=bis.read(bytes))){
            String file=new String(bytes,0,len);
            fileName.append(file);
            if (bytes[len-1]==0x04){
                break;
            }
        }

        fileName=new StringBuilder(fileName.substring(1,fileName.length()-1));
        String[] enterys = fileName.toString().split("\\,");
        for (String en : enterys) {
            String[] kv = en.split("\\=");
            System.out.println("文件："+kv[0]);
            ClientMap.put(kv[0],kv[1]);
        }
        //输入要下载的文件名
        Scanner scanner=new Scanner(System.in);
        String scanFile;
        while (true){
            System.out.println("请输入文件名下载");
            scanFile=scanner.nextLine();
            if (ClientMap.containsKey(scanFile)){
                return scanFile;
            }else {
                System.out.println("文件不存在");
            }
        }
    }
}
