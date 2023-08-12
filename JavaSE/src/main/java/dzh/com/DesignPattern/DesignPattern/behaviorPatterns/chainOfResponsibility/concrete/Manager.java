package dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.concrete;

import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.Leader;
import dzh.com.DesignPattern.DesignPattern.behaviorPatterns.chainOfResponsibility.LeaveRequest;

/**
 * 经理对象
 */
public class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays()<10){
            System.out.println("员工:"+request.getEmpName());
            System.out.println("请假："+request.getLeaveDays()+"天");
            System.out.println("理由："+request.getSeason());
            System.out.println("经理："+this.name+"通过");
        }else {
            if (this.nextLeader!=null){
                this.nextLeader.handleRequest(request);
            }
        }
    }
}