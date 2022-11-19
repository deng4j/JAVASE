package bjsxt.com.io.IOStream;

import java.io.*;

/**
 * 字节流可以处理一切文件
 */
public class FileStream {
    public static void main(String[] args) {
        //创建文件
        String path="D:/idea/bjsxt/src/com/io/file/a.txt";
        File file=new File(path);
        if (file.exists()){
            System.out.println("文件已创建");
        }else {
            try {
                System.out.println("创建文件成功");
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //输出流,true为追加，false覆盖
        OutputStream os=null;
        try {
            os=new FileOutputStream(path,false);
            //字符串转字节数组
            String str="我走了你别再难过，心里有话都不想在说";
            byte[] chars = str.getBytes();
            os.write(chars,0,chars.length);
            //强制刷新一下
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=os){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //输入流
        byte[] bytes=new byte[10];
        InputStream is=null;
        try {
             is=new FileInputStream(file);
             //操作不断读取，缓冲数组
            int len=0;
            while (-1!=(len=is.read(bytes))){
                String info=new String(bytes,0,len);
                System.out.println(info);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            if (null!=is){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("关闭输入流失败");
                }
            }
        }

    }
}
