package dzh.com.tools.hutools;

import cn.hutool.core.bean.BeanUtil;
import dzh.com.tools.hutools.domain.Student;
import dzh.com.tools.hutools.domain.StudentVO;

import java.math.BigDecimal;
import java.util.Date;

public class BeanUtilsTest {
    public static void main(String[] args) {
        copyProperties();
    }

    private static void copyProperties() {
        Student student = new Student("1001", "张三", 23, "男", "陕西西安", "2020-09-01", BigDecimal.valueOf(22.33));
        StudentVO studentVO = new StudentVO();
        BeanUtil.copyProperties(student,studentVO,"enrollmentTime");
        System.out.println(studentVO);
    }
}
