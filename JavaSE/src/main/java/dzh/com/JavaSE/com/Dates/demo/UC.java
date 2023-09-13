package dzh.com.JavaSE.com.Dates.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * T表示分隔符，Z表示的是UTC。
 * UTC：世界标准时间
 * 东加西减8小时
 */
public class UC {
    public static void main(String[] args) {
        CtoU();
    }

    /**
     * 北京时间转国际时间
     */
    private static void CtoU() {
        Date date = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.HOUR_OF_DAY, -8);
        Date newDate = c.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        System.out.println(format.format(newDate));
    }

    /**
     * 世界标准时间转北京时间
     */
    private static void UtoC() {
        String dateTime = "2020-01-13T16:00:00.000Z";
        dateTime = dateTime.replace("Z", " UTC");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS Z");
        SimpleDateFormat defaultFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date time = format.parse(dateTime);
            String result = defaultFormat.format(time);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
