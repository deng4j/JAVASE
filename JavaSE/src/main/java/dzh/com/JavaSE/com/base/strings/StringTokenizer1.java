package dzh.com.JavaSE.com.base.strings;

import java.util.StringTokenizer;

/**
 * 用于分隔字符串
 */
public class StringTokenizer1 {
    public static void main(String[] args) {
        String str="name=123";
        StringTokenizer stringTokenizer=new StringTokenizer(str,"\\=");
        while (stringTokenizer.hasMoreTokens()){
            String s = stringTokenizer.nextToken();
            System.out.println(s);
        }
    }
}
