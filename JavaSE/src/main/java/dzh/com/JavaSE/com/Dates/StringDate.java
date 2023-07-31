package dzh.com.JavaSE.com.Dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDate {
    public static void main(String[] args) {
        m1();
        m2();
        m3();
    }

    private static void m1() {
        //计算机起始时间，1970-1-1，中国时间加8小时
        Date  date1=new Date(0L);
        System.out.println("起始时间："+date1);
        date1.setYear(20);
        System.out.println( "加20年后的时间："+date1);
    }

    private static void m2() {
        //String格式化时间
        Date date2=new Date();
        String year=String.format("%tY",date2);
        String month=String.format("%tm",date2);
        String day=String.format("%td",date2);
        String hour=String.format("%tH",date2);
        String minute=String.format("%tM",date2);
        String second=String.format("%tS",date2);

        String now=String.format("%tF",date2);
        String nowHMS=String.format("%tT",date2);
        System.out.println("分步获取："+year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second);
        System.out.println("%tF+%tT："+now+" "+nowHMS);
    }

    private static void m3() {
        Date date3=new Date();
        //时间格式化
        SimpleDateFormat format=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String now2=format.format(date3);
        System.out.println("格式化时间："+now2);
        //字符串转时间
        try {
            Date now3=format.parse("2030-10-20 12:06:55");
            System.out.println("字符串转时间："+now3);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
