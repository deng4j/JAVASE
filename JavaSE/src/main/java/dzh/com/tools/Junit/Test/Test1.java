package dzh.com.tools.Junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test1 {
    @Test
    public void add(){
        System.out.println("add");
    }

    @Before
    public void before(){
        System.out.println("before at add");
    }
    @After
    public void after(){
        System.out.println("after at add");
    }
}
