package dzh.com.JavaSE.com.IO.FileIO.IOStream;

import java.io.*;

public class copyFile1 {
    public static void main(String[] args) {
        String source="D:/idea/bjsxt/src/com/io/file/a.txt";
        String end="D:/idea/bjsxt/src/com/io/file/b.txt";
        try {
            copyFile(source,end);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-----------------------");
    }
    public static void copyFile(File sourceFile,File endFile) throws IOException {
        if (!sourceFile.isFile()||!sourceFile.isFile()){
            throw  new IOException("只能拷贝文件");
        }
        //选择流,循环+读取+写入
          InputStream is;
          OutputStream os;
          byte[] bytes=new byte[1024];
          int len=0;
          is=new FileInputStream(sourceFile);
          os=new FileOutputStream(endFile);
          //读取
             while (-1!=(len=is.read(bytes))){
                //写出
                os.write(bytes,0,len);
            }
            //强制刷新
            os.flush();
            //先打开后关闭
            os.close();
            is.close();
            System.out.println("复制成功");
    }
    public static void copyFile(String source,String end) throws IOException {
        //读取目标文件
        File sourceFile=new File(source);
        //写入目标文件
        File endFile=new File(end);
        copyFile(sourceFile,endFile);
    }

}
