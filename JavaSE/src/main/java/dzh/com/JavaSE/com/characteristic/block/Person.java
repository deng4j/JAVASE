package dzh.com.JavaSE.com.characteristic.block;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 避免创建不必要的对象，这有效节省了额外的开销
 */
public class Person {
    private Date birthDate;

    private static final Date START;
    private static final Date END;

    static {
        // 避免了创建多个Calendar对象用于初始化属性
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1946,Calendar.JANUARY,1,0,0,0);
        START = calendar.getTime();
        calendar.set(1965,Calendar.JANUARY,1,0,0,0);
        END = calendar.getTime();
    }

    public Person(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 判断是否是人口大爆炸时期出生的
     */
    public Boolean isBabyBoomer(){
        return birthDate.compareTo(START)>=0 && birthDate.compareTo(END)<0;
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        calendar.set(1950,Calendar.JANUARY,1,0,0,0);

        Person person = new Person(calendar.getTime());
        System.out.println(person.isBabyBoomer());
    }
}
