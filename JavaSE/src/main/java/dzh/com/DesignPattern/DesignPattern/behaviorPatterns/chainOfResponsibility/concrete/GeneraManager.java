package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.concrete;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.Leader;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.LeaveRequest;

/**
 * 总经理
 */
public class GeneraManager extends Leader {
    public GeneraManager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<30){
            System.out.println("员工:"+request.getEmpName());
            System.out.println("请假："+request.getLeaveDays()+"天");
            System.out.println("理由："+request.getSeason());
            System.out.println("总经理："+this.name+"通过");
        }else {
            System.out.println("莫非："+request.getEmpName()+"不想干了？");
        }
    }
}