package dzh.com.JavaSE.com.IO.FileIO.ReadWrite;

import dzh.com.JavaSE.com.IO.FileIO.classloader.ClassLoaderTest;

import java.io.*;
import java.util.Arrays;

public class demo3 {
    public static void main(String[] args) throws IOException {

        String classPath = ClassLoaderTest.class.getClassLoader().getResource("").getPath();
        String absolutePath="io/folder/word.txt";
        File file=new File(classPath+absolutePath);

        BufferedReader br=new BufferedReader(
                new FileReader(file)
        );
        String readLine = br.readLine();
        String[] split = readLine.split(" ");
        int[] arr=new int[split.length];
        for (int i = 0; i < split.length; i++) {
            int numb = Integer.parseInt(split[i]);
            arr[i]=numb;
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        br.close();
        BufferedWriter bw=new BufferedWriter(
                new FileWriter(file)
        );
        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]+" ");
        }
        bw.flush();
        bw.close();
    }
}
