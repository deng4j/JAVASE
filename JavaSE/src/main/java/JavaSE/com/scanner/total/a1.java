package JavaSE.com.scanner.total;

import java.util.ArrayList;
import java.util.Scanner;

public class a1 {

    public static void main(String[] args) {
        ArrayList<student> list=new ArrayList<>();
          student s= getstudent();
          list.add(s);
        System.out.println(list.get(0).toString());
    }



    public  static student getstudent(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入id");
        String  id=scanner.next();
        System.out.println("输入姓名");
        String  name=scanner.next();
        System.out.println("输入年龄");
        int  age=scanner.nextInt();
        System.out.println("输入生日");
        String  birth=scanner.next();
        student stu=new student(id,name,age,birth);
        return stu;
    }
}
