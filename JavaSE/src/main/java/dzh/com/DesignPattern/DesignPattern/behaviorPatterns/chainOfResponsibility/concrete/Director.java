package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.concrete;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.Leader;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.LeaveRequest;

/**
 *  ConcreteHandler（具体处理者）：它是抽象处理者的子类，可以处理用户请求，在具体处理 者类中实现了抽象处理者中定义的抽象请求处理方法，
 *  在处理请求之前需要进行判断，看是否有相应的处理权限，如果可以处理请求就处理它，否则将请求转发给后继者；在具体处理 者中可以访问链中下一个对象，以便请求的转发。
 *
 * 主任对象
 */
public class Director extends Leader {
    public Director(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<3){
            System.out.println("员工:"+request.getEmpName());
            System.out.println("请假："+request.getLeaveDays()+"天");
            System.out.println("理由："+request.getSeason());
            System.out.println("主任："+this.name+"通过");
        }else {
            if (this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}