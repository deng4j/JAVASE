package JavaSE.com.Dates;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class date2 {
    public static void main(String[] args) {
        LocalDate localDate=LocalDate.of(2001,01,20);
        LocalDate now=LocalDate.now();
        Period period=Period.between(localDate,now);
        int years = period.getYears()*365;
        int months = period.getMonths()*30;
        int days = period.getDays();
        int all=years+months+days;
        System.out.println(all+"天"+all/356+"岁");
        //三
        LocalDateTime localDateTime=LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String date=localDateTime.format(dateTimeFormatter);
        System.out.println(date);
        //四
        String s="2018-03-04";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date s1=null;
        try {
            s1=format.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat format2=new SimpleDateFormat("yyyy年MM月dd日");
        String s2=format2.format(s1);
        System.out.println(s2);
    }
}
