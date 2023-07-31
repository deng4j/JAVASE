package dzh.com.JavaSE.com.IO.FileIO.ReadWrite;

import dzh.com.JavaSE.com.IO.FileIO.classloader.ClassLoaderTest;

import java.io.*;

/**
 * 输出流会清空文件数据，注意不要放在read前面
 */
public class BufferedRW {
    public static void main(String[] args) throws IOException {
        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();

        File file=new File(classPath+"io/folder/c/word.txt");
        write(file);
        read(file);
    }

    /**
     * readline（）读到换行符为止
     * @param file
     * @throws IOException
     */
    private static void read(File file) throws IOException {
        Reader br=new BufferedReader(
                new FileReader(file)
        );
        String line=null;
        while (null!=(line=((BufferedReader) br).readLine())){
            System.out.println(line);
        }
        br.close();
    }

    private static void write(File file) throws IOException {
        Writer bw=new BufferedWriter(
                new FileWriter(file,true)
        );
        String str="我是梁志超他奶妈，你们怎么教育他的，他骂我是傻逼";
        bw.write(str);
        ((BufferedWriter) bw).newLine();
        bw.flush();
        bw.close();
    }
}
