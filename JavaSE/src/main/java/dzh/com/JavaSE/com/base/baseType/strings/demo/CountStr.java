package dzh.com.JavaSE.com.base.baseType.strings.demo;

import java.util.Scanner;

public class CountStr {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();

        for (int i=0;i<str.length();i++){
            char cha=str.charAt(i);
            System.out.println(cha);
        }
        //toCharArray()
        System.out.println("toCharArray()");
        char[] chars = str.toCharArray();
        int num =0;
        int down=0;
        int upper=0;
        for (int i=0;i<chars.length;i++){
            System.out.println(chars[i]);
            if (chars[i]>='0' &&(int) chars[i]<='9'){
                num++;
            }
            if (chars[i]>='a'&&chars[i]<='z'){
                down++;
            }
            if (chars[i]>='A'&&chars[i]<='Z'){
                upper++;
            }
        }
        System.out.println("数字："+num+"小写字母："+down+"大写字母："+upper);
    }
}
