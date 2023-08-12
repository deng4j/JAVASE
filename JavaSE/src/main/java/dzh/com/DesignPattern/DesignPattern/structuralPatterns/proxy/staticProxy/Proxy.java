package dzh.com.DesignPattern.DesignPattern.structuralPatterns.proxy.staticProxy;


/**
 *  Proxy（代理主题角色）：它包含了对真实主题的引用，从而可以在任何时候操作真实主题对象；
 *  在代理主题角色中提供一个与真实主题角色相同的接口，以便在任何时候都可以替代真实主题；
 *  代理主题角色还可以控制对真实主题的使用，负责在需要的时候创建和删除真实主题对象，并对真实主题对象的使用加以约束。
 *  通常，在代理主题角色中，客户端在调用所 引用的真实主题操作之前或之后还需要执行其他操作，而不仅仅是单纯调用真实主题对象中的操作。
 */
public class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        preRequest();
        subject.request();
        postRequest();
    }

    private void preRequest(){
        System.out.println("前置通知");
    }

    private void postRequest(){
        System.out.println("后置通知");
    }
}
