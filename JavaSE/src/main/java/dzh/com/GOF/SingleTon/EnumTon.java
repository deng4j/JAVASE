package dzh.com.GOF.SingleTon;

/**
 * 定义一个枚举元素，代表一个单例的实例。
 * 枚举本身就是一个单例模式由JVM从根本上提供保障，
 * 避免通过反射和反序列化的漏洞
 * 没有延迟加载
 */
public enum  EnumTon {
    INSTANCE;
    public void singleTonOperation(){

    }
}