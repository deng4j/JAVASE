package JavaSE.com.exception.student;

import java.util.Scanner;

public class StuTest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Student s=new Student();
        s.setName("张三");
        while (true){
            System.out.println("请输入年龄");
            String agestr=scanner.nextLine();
            try {
                int age=Integer.parseInt(agestr);
                s.setAge(age);
                break;
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(s.toString());
    }
}
