package JavaSE.com.Reflect.case2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class case3 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add((int)(Math.random()*33+1));
        }
        System.out.println(list);
        //向对象名为 list的集合 中添加String类型的对象
        Class aClass = list.getClass();
        Method add = aClass.getDeclaredMethod("add", Object.class);
        add.setAccessible(true);
        add.invoke(list,"你是sb");
        System.out.println(list);
    }
}
