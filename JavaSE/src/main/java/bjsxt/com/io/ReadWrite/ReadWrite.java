package bjsxt.com.io.ReadWrite;

import java.io.*;

public class ReadWrite {
    public static void main(String[] args) {
        File file1=new File("D:/idea/bjsxt/src/com/io/file/RW.txt");
        if (file1.exists()){
            System.out.println("文件已存在");
        }else {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //字符输出流
        String str="忽如一夜春风来，千树万树梨花开\n";
        char[] chars1 = str.toCharArray();
        Writer writer=null;
        try {
            writer=new FileWriter(file1,false);
            writer.write(chars1);
            writer.append("给我康康那\n");
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (null!=writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //选择字输入流
        System.out.println("-------------reader---------------");
        Reader reader=null;
        try {
             reader=new FileReader(file1);
             //读取操作
            char[] chars=new char[10];
            int len=0;
            while (-1!=(len=reader.read(chars))){
                String info=new String(chars,0,len);
                System.out.println(info);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null!=reader){
                try {
                    reader.close();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
