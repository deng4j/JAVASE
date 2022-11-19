package JavaSE.com.enums.Employee;

public enum EmployeeDimissionStatus {
    APPLYFOR("0","申请离职"),AGREED("1","同意申请"), OPPOSE("2","驳回申请"),INCUMBENCY("-1","在职");
    private final String status;
    private final String msg;

    EmployeeDimissionStatus(String status, String msg) {
        this.status=status;
        this.msg=msg;
    }

    public String getCode()
    {
        return status;
    }

    public String getInfo()
    {
        return msg;
    }

    public static EmployeeDimissionStatus getByMsg(String msg) throws Exception {
        EmployeeDimissionStatus[] values = EmployeeDimissionStatus.values();
        for (EmployeeDimissionStatus value: values) {
            if (value.getInfo().equals(msg)){
                return value;
            }
        }
        throw new Exception();
    }
}