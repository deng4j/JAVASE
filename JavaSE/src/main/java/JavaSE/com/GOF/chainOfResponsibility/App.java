package JavaSE.com.GOF.chainOfResponsibility;

/**
 * 责任链模式：
 * 将能处理同一类请求的对象连成一条链，所提交的请求沿链逐级处理。
 *
 * 使用责任链模式模拟请假。
 * 链表方式定义责任链。
 * 非链表方式实现责任链（使用集合生成责任链）
 *
 * 应用场景：异常捕捉，servelet中过滤器
 */
public class App {
    public static void main(String[] args) {
        Leader director =new Director("张三");
        Leader manager =new Manager("李四");
        Leader generaManager=new GeneraManager("王五");

        //组织责任链对象关系
        director.setNextLeader(manager);
        manager.setNextLeader(generaManager);

        //开始请假
        LeaveRequest request=new LeaveRequest("罗翔",11,"去b站直播");
        director.handleRequest(request);
    }
}
