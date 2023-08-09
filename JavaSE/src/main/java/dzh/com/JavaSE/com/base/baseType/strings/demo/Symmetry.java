package dzh.com.JavaSE.com.base.baseType.strings.demo;

import java.util.Scanner;

public class Symmetry {

    public static void check(String  str){
        char[] chars=str.toCharArray();
        for (int i=0;i<chars.length;i++){
            if(chars[i]==chars[chars.length-i-1]&&i==chars.length-1){
                System.out.println("是对称");
            }else if(chars[i]!=chars[chars.length-i-1]){
                System.out.println("不是");
                break;
            }
        }
    }
    public static void main(String[] args) {
        System.out.println("请输入一串字母");
        Scanner scanner=new Scanner(System.in);
        String str=scanner.nextLine();
        check(str);
    }
}
