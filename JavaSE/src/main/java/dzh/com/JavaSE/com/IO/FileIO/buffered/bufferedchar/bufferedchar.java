package dzh.com.JavaSE.com.IO.FileIO.buffered.bufferedchar;

import java.io.*;

public class bufferedchar {
    public static void main(String[] args) {
        File file=new File("D:/idea/bjsxt/src/com/io/file/a.txt");
        BufferedWriter writer=null;
        BufferedReader reader=null;

        try {
            String str="垂死病中惊坐起，暗风吹雨入寒窗";
            writer=new BufferedWriter(new FileWriter(file));
            writer.write(str);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
