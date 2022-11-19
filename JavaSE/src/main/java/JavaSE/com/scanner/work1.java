package JavaSE.com.scanner;

import java.util.ArrayList;
import java.util.Scanner;

public class work1 {

    public static void put(){
        ArrayList arr=new ArrayList();
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入年龄");
        String age=scanner.next();
        arr.add(age);
        System.out.println("请输入身高");
        String height=scanner.next();
        arr.add(height);
        System.out.println("请输入体重");
        String weight=scanner.next();
        arr.add(weight);
        System.out.println("................");

        for(int i=0;i<arr.size();i++){
            String str= (String) arr.get(i);
            System.out.println(str);
        }
    }

    public static void main(String[] args) {
        work1 a=new work1();
        a.put();
    }
}
