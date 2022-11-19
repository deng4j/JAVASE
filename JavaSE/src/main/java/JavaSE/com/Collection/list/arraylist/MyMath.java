package JavaSE.com.Collection.list.arraylist;

import JavaSE.com.Collection.list.arraylist.domain.Student2;

import java.util.ArrayList;

public class MyMath {
    public static void main(String[] args) {
        ArrayList<Student2> list=new ArrayList<>();
        Student2 s1=new Student2("张三",18,78);
        Student2 s2=new Student2("李四",19,100);
        Student2 s3=new Student2("王五",15,50);
        Student2 s4=new Student2("刘六",17,50);
        Student2 s5=new Student2("二狗",15,78);
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);

        Student2 high=getScore(list);
        System.out.println(high.toString());

        int ave=getAverage(list);
        System.out.println(ave);
        
        ArrayList lower=getLower(list);
        System.out.println(lower.toString());
    }

    private static ArrayList<Student2> getLower(ArrayList<Student2> list) {
        ArrayList<Student2> list1=new ArrayList<>();

        for (int i=0;i<list.size();i++){
           if (list.get(i).getScore()<60){
               list1.add(list.get(i));
           }
        }
        return list1;
    }

    private static int getAverage(ArrayList<Student2> list) {
        int total=0;
        for (int i=0;i<list.size();i++){
            total+=list.get(i).getScore();
        }
        return total/list.size();
    }

    private static Student2 getScore(ArrayList<Student2> list) {
        int score=list.get(0).getScore();
        int index=0;
        for (int i=0;i<list.size();i++){
            if (score<list.get(i).getScore()){
                score=list.get(i).getScore();
                index=i;
            }
        }
        return list.get(index);
    }
}
