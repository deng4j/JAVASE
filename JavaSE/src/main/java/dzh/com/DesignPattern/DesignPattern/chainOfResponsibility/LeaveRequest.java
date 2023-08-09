package dzh.com.DesignPattern.DesignPattern.chainOfResponsibility;

/**
 * 封装请假的基本信息
 */
public class LeaveRequest {
    private String empName;
    private int leaveDays;
    private String season;

    public LeaveRequest() {
    }

    public LeaveRequest(String empName, int leaveDays, String season) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.season = season;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
