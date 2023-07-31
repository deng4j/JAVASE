package dzh.com.JavaSE.com.IO.FileIO.classloader;

import java.io.*;

public class ClassLoaderTest {

    public static void main(String[] args) throws IOException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();
        String absolutePath="io/folder/word.txt";
        File file=new File(classPath+absolutePath);
        BufferedReader bw=new BufferedReader(
                new InputStreamReader(new FileInputStream(file),"utf-8")
        );
        String str=null;
        while (null!=(str=bw.readLine())){
            System.out.println(str);
        }
        bw.close();
    }
}
