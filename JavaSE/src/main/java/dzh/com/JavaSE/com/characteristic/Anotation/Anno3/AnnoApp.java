package dzh.com.JavaSE.com.characteristic.Anotation.Anno3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoApp {

    @MyAnnotation(name = "李梓萌",value = "")
    public void show(String name){
        System.out.println(name);
    }

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<AnnoApp> annoAppClass = AnnoApp.class;
        Method show = annoAppClass.getMethod("show", String.class);
        show.setAccessible(true);
        AnnoApp annoApp = annoAppClass.newInstance();
        show.invoke(annoApp,"deng");
        MyAnnotation annotation = show.getAnnotation(MyAnnotation.class);
        System.out.println(annotation);
    }
}
