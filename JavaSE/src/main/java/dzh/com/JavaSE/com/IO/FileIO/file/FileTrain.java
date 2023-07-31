package dzh.com.JavaSE.com.IO.FileIO.file;

import dzh.com.JavaSE.com.IO.FileIO.classloader.ClassLoaderTest;

import java.io.*;
import java.util.Scanner;

public class FileTrain {
    private static Scanner scanner=new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        File file = createFile();
        write(file);
        String read = read(file);
        System.out.println(read);

    }

    private static String read(File file) throws IOException {
        BufferedReader br=new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file)
                )
        );
        String str=null;
        str=br.readLine();
        br.close();
        return str;
    }

    private static void write(File file) throws IOException {
        System.out.println("请输入文章");
        String str=scanner.nextLine();
        BufferedWriter bos=new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(file,true))
        );
        bos.write(str);
        bos.flush();
        bos.close();
    }

    private static File createFile() throws IOException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();
        String absolutePath="io/folder";

        String path=classPath+absolutePath;
        File file=null;
        String str=null;
        while (true){
            System.out.println("请输入一个路径");
            str=scanner.nextLine();
            file=new File(path,str);
            if (!file.exists()){
                file.mkdirs();
            }
            System.out.println("请输入一个文件名");
            str=scanner.nextLine();
            file=new File(file,str);
            if (!file.exists()){
                file.createNewFile();
                System.out.println("文件创建成功");
            }else {
                System.out.println("文件已存在");
            }
            break;
        }
        return file;
    }
}
