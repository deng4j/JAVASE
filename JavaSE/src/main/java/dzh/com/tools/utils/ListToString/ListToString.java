package dzh.com.tools.utils.ListToString;

import java.io.*;

public class ListToString {
    public static void main(String[] args) throws IOException {
        Reader br=new BufferedReader(new FileReader("src/main/java/dzh/com/tools/utils/ListToString/temp.txt"));

        StringBuilder str = new StringBuilder();
        String line;
        while (null!=(line=((BufferedReader) br).readLine())){
            str.append(line);
        }
        br.close();

        String newStr = str.toString().replace("),", "),\n").replace(")]",")]\n");
        System.out.println(newStr);
    }
}
