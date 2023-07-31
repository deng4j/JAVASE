package dzh.com.GOF.chainOfResponsibility;

/**
 * 主任对象
 */
public class Director extends Leader {
    public Director(String name) {
        super(name);
    }

    @Override
    void handleRequest(LeaveRequest request) {
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

/**
 * 经理对象
 */
class Manager extends Leader {

    public Manager(String name) {
        super(name);
    }

    @Override
    void handleRequest(LeaveRequest request) {
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

/**
 * 总经理
 */
 class GeneraManager extends Leader{
    public GeneraManager(String name) {
        super(name);
    }

    @Override
    void handleRequest(LeaveRequest request) {
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


