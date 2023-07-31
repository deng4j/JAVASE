package dzh.com.GOF.SingleTon;

public class HungryTon {
    /**
     * 饿汉式单例模式：
     *
     * 类初始化时立刻加载这个对象（没有延迟优势）。类加载天然是线程安全的；
     * 没有同步锁，调用效率高
     */
    public static HungryTon hungryTon=new HungryTon();
    private HungryTon(){};

    public static HungryTon getHungryTon(){
        return hungryTon;
    }
}
