package dzh.com.tools.hutools;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class HutoolDateTimeTest {

    public static void main(String[] args) {
        m3();
    }

    private static void m3() {
        String date = DateUtil.year(new Date())+"01";
        DateTime dateTime = DateUtil.parse(date, "yyyyMM");
        System.out.println(dateTime);
    }

    private static void m1() {
        DateTime dateTime = DateUtil.parseDate("2022/12/01");
        System.out.println(dateTime);

        boolean notBlank = StrUtil.isBlank(null);
        System.out.println(notBlank);

        DateTime date1 = DateUtil.parseDate("2022/12/00");
        System.out.println(date1);

        Date date=null;
        String nowFormat = DateUtil.format(date, "yyyy-MM-dd");
        System.out.println(nowFormat);
        ;
        String addOne = DateUtil.format(DateUtil.offsetDay(new Date(),1), "yyyy-MM-dd");
        System.out.println(addOne);

        DateTime dateS = DateUtil.parseDate("2022-12-01");
        System.out.println(dateS);
    }

    private static void m2() {
        DateTime dateTime0 = DateUtil.parse("2022/10", "yyyy/MM");
        DateTime dateTime1 = DateUtil.parse("2022/11", "yyyy/MM");
        DateTime dateTime2 = DateUtil.parse("2022/11", "yyyy/MM");
        DateTime dateTime3 = DateUtil.parse("2022/12", "yyyy/MM");
        System.out.println(dateTime1.compareTo(dateTime2));

        Comparator<DateTime> comparator=(s1, s2)->s1.compareTo(s2);

        List<DateTime> dateTimeList= Arrays.asList(dateTime1,dateTime0,dateTime2,dateTime3);
        dateTimeList.sort(comparator);
        System.out.println(dateTimeList);
    }

    private void offset(){
        System.out.println(DateUtil.offsetDay(new Date(),-8));
    }
}

