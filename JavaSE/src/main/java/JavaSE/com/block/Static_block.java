package JavaSE.com.block;

public class Static_block {

    public static String name;
    /**
     * 在类的初始化阶段执行。
     * 优先于构造方法,只执行一次
     */
    static  {
        Static_block.name="你干嘛";
    }

    public Static_block() {
        System.out.println("\033[32m" + "---------空参--------" + "\033[0m");
    }

    public Static_block(String name) {
        System.out.println("\033[32m" + "---------带参--------" + "\033[0m");
    }

    public static void main(String[] args) {
        Static_block s1=new Static_block();
        Static_block s2=new Static_block("没事就吃溜溜梅吧");
        System.out.println(Static_block.name);
    }
}

