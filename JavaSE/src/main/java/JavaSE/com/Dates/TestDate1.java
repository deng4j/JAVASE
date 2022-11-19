package JavaSE.com.Dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate1 {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format=new  SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date1=format.parse("2030-10-20 12:06:55");
        Date date2=format.parse("2028-10-20 12:06:55");
        Date date3=format.parse("2028-10-20 12:06:55");

        System.out.println("==："+(date3==date2));
        System.out.println("hashCode："+(date3.hashCode()==date2.hashCode()));
    }
}
