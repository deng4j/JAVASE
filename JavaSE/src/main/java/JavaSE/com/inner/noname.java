package JavaSE.com.inner;

/**
 * lambda表达式只能用于函数式接口，
 * 匿名内部类可以有多个方法。
 */

interface  swimming{
    void swim();
}
public class noname  {
    public static void main(String[] args) {
      swimming s=   new swimming(){

            @Override
            public void swim() {
                System.out.println("游泳");
            }
        };
      s.swim();

      swimming swimming=()->{
          System.out.println("lambda");
      };
      swimming.swim();
    }
}
