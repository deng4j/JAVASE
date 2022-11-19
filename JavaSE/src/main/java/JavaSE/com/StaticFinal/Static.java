package JavaSE.com.StaticFinal;


public class Static {
    static  int a=47;

    public static void show(){
        // static  int a=47;  //不能再方法中定义静态变量
//        this.a=14;//静态方法不能有this
//        this.set();//静态方法不能直接调用非静态方法
          new Static().set();
    }

    public void  set(){
        a=57;
        System.out.println(a);
    }

    public static void main(String[] args) {
        Static s=new Static();
        s.set();

        Static.show();
    }

}
