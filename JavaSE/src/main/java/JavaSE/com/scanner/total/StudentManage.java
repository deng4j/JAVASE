package JavaSE.com.scanner.total;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManage {


    public  static void input(){


        Scanner a=new Scanner(System.in);
        ArrayList<student> list=new ArrayList();
        lo: while (true) {
            System.out.println("1添加学生,2删除学生,3修改学生,4查看学生,5退出");
            String b=a.next();
            switch (b) {
                case "1":
                    System.out.println("1添加学生");
                    addstudent(list);
                    break;
                case "2":
                    System.out.println("2删除学生");
                    removestudent(list);
                    break;
                case "3":
                    System.out.println("3修改学生");
                    setstudent(list);
                    break;
                case "4":
                    System.out.println("4查看学生");
                    getstudent(list);
                    break;
                case "5":
                    System.out.println("5退出");
                    break lo;
                 default:
                     break ;
            }
        }

    }

    private static void setstudent(ArrayList<student> list) {
            System.out.println("请输入要修改的信息");
            Scanner in=new Scanner(System.in);
            String a=in.next();
            System.out.println("将"+a+"修改成");
            for (int i=0;i<list.size();i++){
                    student st=list.get(i);
                    String b=in.next();

                    if(a.equals(st.getSid())){
                        st.setSid(b);
                        System.out.println("修改成功");
                    }else if (a.equals(st.getName())){
                        st.setName(b);
                        System.out.println("修改成功");
                    }else if (a.equals(st.getAge())){
                        st.setAge(Integer.parseInt(b));
                        System.out.println("修改成功");
                    }else if (a.equals(st.getBirthday())){
                        st.setBirthday(b);
                        System.out.println("修改成功");
                    }else {
                        System.out.println("未找到相关信息");
                    }
            }


    }


    private static void removestudent(ArrayList<student> list) {
        System.out.println("请输入学生姓名");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        for (int i=0;i<list.size();i++){
            if (name.equals(list.get(i).getName())){
                list.remove(i);
                i--;
            }else if (i==list.size()-1||list.size()==0){
                System.out.println("查无此人");
            }

        }
    }

    private static void getstudent(ArrayList<student> list) {
        System.out.println("姓名"+"\t"+"id"+"\t"+"年龄"+"\t"+"生日");
        for (int i=0;i<list.size();i++){
            student st=list.get(i);
            System.out.println(st.getName()+"\t"+st.getSid()+"\t"+st.getAge()+"\t"+st.getBirthday());
        }
    }

    public static int checkid(ArrayList<student> list,String sid){
        int index=-1;
        for (int i=0;i<list.size();i++){
            if ( sid.equals(list.get(i).getSid())){
                index=i;
            }
        }
        return index;
    }

    private static void addstudent(ArrayList<student> list) {
        Scanner inp=new Scanner(System.in);
        String sid;
        if (list.size()==0){
            System.out.println("输入学生id");
             sid=inp.next();
        }else {
            System.out.println("输入学生id");
                 sid=inp.next();
            for (int i = 0; i <list.size() ; i++) {
                if (checkid(list,sid)>=0){
                    System.out.println("id重复");
                    sid=inp.next();
                    i--;
                }
            }
        }

            System.out.println("输入学生name");
            String name=inp.next();

            System.out.println("输入学生age");
            int age=inp.nextInt();

            System.out.println("输入学生birthday");
            String birthday=inp.next();

            student stu=new student(sid,name,age,birthday);

            list.add(stu);



    }

    public static void main(String[] args) {
        StudentManage c=new StudentManage();
           c.input();


    }
}
