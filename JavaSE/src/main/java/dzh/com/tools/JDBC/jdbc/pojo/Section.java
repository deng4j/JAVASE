package dzh.com.tools.JDBC.jdbc.pojo;

/**
 * 实体类使用包装数据类型
 */
public class Section {
    private Integer sid;
    private String sname;

    public Section() {
    }

    public Section(int sid, String sname) {
        this.sid = sid;
        this.sname = sname;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
