package JavaSE.com.IO.ReadWrite;

import JavaSE.com.IO.classloader.ClassLoaderTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class demo2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入用户名");
        String uid=scanner.nextLine();
        System.out.println("请输入密码");
        String pwd=scanner.nextLine();

        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();

        File file=new File(classPath+"io/folder/c/word.txt");

        Writer w=new FileWriter(file);
        w.write(uid);
        w.write("\r\n");
        w.write(pwd);
        w.flush();
        w.close();

    }
}
