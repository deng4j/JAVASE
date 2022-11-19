package JavaSE.com.String;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class replace {
    public static void main(String[] args) {
        replace2();
    }

    private static void replace2() {
        //去除html标记
        Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher("<a href=\"index.html\">主页</a>");
        String string = matcher.replaceAll("");
        System.out.println(string);
    }

    private static void replace1() {
        String[] www={"nmm","cnm","tmd","rnm"};
        System.out.println("请输入骂人语句");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        String newstr;
        for (int i = 0; i <www.length ; i++) {
            if ( str.indexOf(www[i])!=-1 ){
                 newstr=str.replace(www[i],"***");
                System.out.println(newstr);
                break;
            }else if(i==www.length-1){
                newstr=str;
                System.out.println(newstr);
            }
        }
    }
}
