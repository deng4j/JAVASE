package JavaSE.com.testFrame;

import java.text.ParseException;

public class TestDemo {
    @Anno
    public void show(){
        int[] arr={123,1,1231};
        System.out.println(arr[8]);
    }
    @Anno
    public void run(){
        String str=null;
        System.out.println(str.length());
    }
    @Anno
    public void met(){
        System.out.println("我是你爸爸");
    }
    @Anno
    public void function() throws ParseException {
        throw  new ParseException("转化异常",1);
    }
    @Anno
    public void add(){
        System.out.println("做一次牢");
    }
}
