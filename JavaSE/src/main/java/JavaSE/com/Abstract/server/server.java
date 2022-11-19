package JavaSE.com.Abstract.server;


public abstract class server {
    public String name;

    public abstract void work();

    public void show(){
         System.out.println("我是抽象类");
     }

}

class test extends server{

    /**
     * 重写后的方法访问权限必须大于等于父类中的方法权限
     */
    @Override
    public void work() {

    }

    public static void main(String[] args) {
        test t=new test();
        t.name="kk";
        System.out.println(t.name);
    }
}
