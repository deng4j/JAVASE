package dzh.com.JavaSE.com.IO.FileIO.properties;

import dzh.com.JavaSE.com.IO.FileIO.classloader.ClassLoaderTest;

import java.io.*;
import java.util.Properties;

public class Props {
    public static void main(String[] args) throws IOException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();

        File file=new File(classPath+"io/folder/props.properties");
        Reader br=new BufferedReader(
                new FileReader(file)
        );

        Properties props=new Properties();
        props.load(br);
        br.close();
        props.setProperty("张三","1232");
        System.out.println(props);
        Writer w=new BufferedWriter(new FileWriter(file));
        props.store(w,null);
        w.close();

    }
}
