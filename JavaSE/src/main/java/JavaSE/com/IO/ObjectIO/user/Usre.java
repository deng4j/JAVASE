package JavaSE.com.IO.ObjectIO.user;

import java.io.Serializable;

public class Usre implements Serializable {
    //指定序列化值,防止修改对象从而改变序列号
    private static final long serialVersionUID = 1L;
    private int uid;
    private String pwd;
    private transient String name;

    public Usre(int uid, String pwd, String name) {
        this.uid = uid;
        this.pwd = pwd;
        this.name = name;
    }

    public Usre() {
    }

    @Override
    public String toString() {
        return "usre{" +
                "uid=" + uid +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
