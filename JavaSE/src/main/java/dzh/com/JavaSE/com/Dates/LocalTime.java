package dzh.com.JavaSE.com.Dates;

import java.text.ParseException;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class LocalTime {
    public static void main(String[] args) throws ParseException {
        m3();
    }


    private static void m1() {
        LocalDateTime date=LocalDateTime.now();
        System.out.println("LocalDateTime当前时间："+date);
    }


    private static void m2() {
        LocalDateTime date= LocalDateTime.of(2021,10,8,12,50,12);
        //获取单独的日期
        int year = date.getYear();
        DayOfWeek dayOfWeek =date.getDayOfWeek();
        int monthValue = date.getMonthValue();

        System.out.println("LocalDateTime设置的时间："+date);
        System.out.println(  year+"年"+monthValue+"月"+"星期："+dayOfWeek);
    }

    private static void m3() {
        LocalDateTime date= LocalDateTime.of(2022,10,8,12,50,12);

        //转化成localdate对象
        LocalDate localDate=date.toLocalDate();
        System.out.println("localdate对象:"+localDate);

        //localdate对象格式化
        DateTimeFormatter pattern1=DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String localDate2 = localDate.format(pattern1);
        System.out.println("localdate对象格式化："+localDate2);

        //转化成localtime对象
        java.time.LocalTime localTime=date.toLocalTime();
        System.out.println("LocalTime对象:"+localTime);
    }

    private static void m4() {
        LocalDateTime date= LocalDateTime.of(2031,10,8,12,50,12);

        //格式化
        DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String s = date.format(pattern);
        System.out.println("格式化LocalDateTime："+s);

        String s1 = "2021年10月08日 06:15:55";
        LocalDateTime parse = LocalDateTime.parse(s1,pattern);
        String formatDate = parse.format(pattern);
        System.out.println("string转LocalDateTime："+formatDate);
    }

    private static void m5() {
        LocalDateTime date3= LocalDateTime.of(2021,10,8,12,50,12);

        //日期运算
        LocalDateTime newdate2 = date3.plusYears(1);
        System.out.println(newdate2);
        //日期修改
        LocalDateTime s3 = date3.withYear(2040);
        System.out.println(s3);

        //时间隔对象Period
        LocalDateTime date22=LocalDateTime.of(2023,11,20,12,15,50);
        Period between=Period.between(date22.toLocalDate(),date3.toLocalDate());
        System.out.println("年数差:"+between.getYears());
        System.out.println("天数差:"+between.getDays());
        System.out.println("月数差:"+between.getMonths());
        System.out.println("获取总月数差："+between.toTotalMonths());

        //时间差duration
        Duration duration=Duration.between(date22.toLocalTime(),date3.toLocalTime());
        System.out.println("秒间隔"+duration.toSeconds());
        System.out.println("分间隔"+duration.toMinutes());
        System.out.println("小时间隔"+duration.toHours());
    }
}
