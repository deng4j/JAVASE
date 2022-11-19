package JavaSE.com.IO.exmaple;

import JavaSE.com.IO.classloader.ClassLoaderTest;

import java.io.*;

public class exam1 {
    public static void main(String[] args) throws IOException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();
        String absolutePath="io/folder/example/a.txt";
        File file=new File(classPath+absolutePath);
        if (!file.exists()){
            file.createNewFile();
        }
        BufferedReader br=new BufferedReader(new FileReader(file));
        int i=0;
        String str=null;
        str=br.readLine();
        if (str!=null&&!str.equals("")){
            i=Integer.parseInt(str)+1;
        }
        BufferedWriter bw =new BufferedWriter(new FileWriter(file));
        bw.write(String.valueOf(i));
        bw.flush();
        bw.close();
        if (i>2){
            System.out.println("免费3次使用完毕，请注册");
            while (true){
                //注意read读到一半不能重新读
                String uname=br.readLine();
                String upwd=br.readLine();
                System.out.println(uname);
                System.out.println(upwd);
                break;
            }
        }

    }
}
