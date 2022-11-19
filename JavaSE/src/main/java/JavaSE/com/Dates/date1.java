package JavaSE.com.Dates;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.Scanner;

public class date1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int year;
        while (true) {
            System.out.println("请输入年份");
            String date1 = scanner.nextLine();
            try {
                year = Integer.parseInt(date1);
                break;
            }catch (NumberFormatException e){
                System.out.println("输入有误");
            }
        }
        LocalDate localDate1=LocalDate.of(year,1,1);
        int fullYear = localDate1.lengthOfYear();
        if (fullYear==366){
            System.out.println(year+"闰年");
        }else {
            System.out.println(year+"平年");
        }
        //-----------
        Calendar c=Calendar.getInstance();
        c.set(year,2,1);
        c.add(Calendar.DATE,-1);
        int i = c.get(Calendar.DATE);
        if (i>28){
            System.out.println(year+"闰年");
        }else {
            System.out.println(year+"平年");
        }


    }
}
