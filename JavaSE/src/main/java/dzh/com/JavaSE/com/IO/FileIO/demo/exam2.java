package dzh.com.JavaSE.com.IO.FileIO.demo;

import dzh.com.JavaSE.com.IO.FileIO.classloader.ClassLoaderTest;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class exam2 {
    public static void main(String[] args) throws IOException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();
        String absolutePath="io/folder/example/b.txt";

        File file=new File(classPath+absolutePath);
        Scanner scanner=new Scanner(System.in);
        BufferedWriter bw=new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < 3; i++) {
            String code = getcode();
            System.out.println(code);
            bw.write(code);
            bw.newLine();
            bw.flush();
        }
        bw.close();

        BufferedReader br=new BufferedReader(new FileReader(file));
        String str=null;
        String code=null;
        ArrayList<String> list=new ArrayList<>();
        while (null!=(str=br.readLine())){
            list.add(str);
        }
        br.close();
       loop: while (true){
           System.out.println("请输入验证码");
            code=scanner.nextLine();
            for (String s : list) {
                if (s.equalsIgnoreCase(code)){
                    System.out.println("验证成功");
                    break loop;
                }
            }
            System.out.println("验证码错误！");
        }
    }

    public static String getcode(){
        StringBuilder strbuidler=new StringBuilder();
        Random random=new Random();
        int index=random.nextInt(5);
        for (int i = 0; i < 5; i++) {
            if (index==i){
                strbuidler.append(random.nextInt(10));
            }else {
                strbuidler.append((char)(random.nextInt(26)+65));
            }
        }
        return String.valueOf(strbuidler);

    }
}
