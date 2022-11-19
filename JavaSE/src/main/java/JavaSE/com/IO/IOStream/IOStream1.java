package JavaSE.com.IO.IOStream;

import JavaSE.com.IO.classloader.ClassLoaderTest;

import java.io.*;


public class IOStream1 {
    public static void main(String[] args)  {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();

        File file1=new File(classPath+"io/folder/b");
        File file=new File(file1,"word.txt");
        FileOutputStream out=null;
        try {
            if (!file1.exists()){
                file1.mkdirs();
            }
            if (file.exists()){
                System.out.println("文件已创建");
            }else {
                file.createNewFile();
            }

             out=new FileOutputStream(file,true);
            byte[] b="垂死病中惊坐起，暗风吹雨入寒窗".getBytes();
            out.write(b);
            out.write("\r\n".getBytes());
            out.flush();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        FileInputStream input= null;
        try {
            input = new FileInputStream(file);
            //一次可以读取1024个字节
            byte by[] =new byte[1024];
            int len=0;
            while(-1!=(len=input.read(by))){
                System.out.println(len);
                String str=new String(by,0,len);
                System.out.println("info:"+str);
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
