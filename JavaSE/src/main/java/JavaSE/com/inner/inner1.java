package JavaSE.com.inner;

interface innerface{}

public class inner1 {//外部类
    int a=10;

    public void show(){
        System.out.println("show");
    }

    private  class inner2{//私有内部类2
        int a=inner1.this.a;

        public void show(){
            inner1.this.show();
        }


         class inner3 extends inner1 implements innerface{//内部类3继承外部类
            public void doinner(){//方法


                class inner4{//局部内部类
                    public innerface doinner2(){//方法
                        return new innerface(){//匿名内部类,实现接口的匿名对象

                        };
                    }
                }
            }
        }
    }
    public  Object getInner2(inner1 in1 ){
        inner1.inner2 in2=in1.new inner2();
        return in2.a;
    }
    public  Object getInner2( ){
        inner1.inner2 in2=new inner1().new inner2();
        return in2.a;
    }

    //静态内部类
     static class StaticInner{
        private static String name;

        public void show(){
            System.out.println("静态内部类");
        }
    }

    public static void getStatic(){
        new StaticInner().show();
    }

}


class test{
    public static void main(String[] args) {
        inner1 in1=new inner1();
        int a= (int) in1.getInner2();
        System.out.println(a);

        inner1.getStatic();
    }
}
