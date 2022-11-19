package JavaSE.com.thinkingInJava4.imiSpring;

import java.io.IOException;

public class TestApp {
    public static void main(String[] args) throws IOException {
        Object student = BeanUtils.getBean("student");
        System.out.println(student);
    }
}
