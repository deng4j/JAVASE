package dzh.com.DesignPattern.DesignPattern.structuralPatterns.proxy.staticProxy;

/**
 * Subject（抽象主题角色）：它声明了真实主题和代理主题的共同接口，这样一来在任何使 用真实主题的地方都可以使用代理主题，客户端通常需要针对抽象主题角色进行编程。
 */
public interface Subject {
    void request();
}
