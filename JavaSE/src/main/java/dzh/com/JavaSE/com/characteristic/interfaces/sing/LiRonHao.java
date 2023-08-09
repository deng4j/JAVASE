package dzh.com.JavaSE.com.characteristic.interfaces.sing;

public class LiRonHao implements SingSongWriter{

    private String name;

    public LiRonHao(String name) {
        this.name=name;
    }

    @Override
    public void sing(String name) {
        System.out.println("歌手："+name+" 星光大道演唱"+name);
    }

    @Override
    public void compose(String name) {
        System.out.println("歌手："+name+" 编写歌曲："+name);
    }

    @Override
    public void issuance(String name) {
        this.compose(name);
        this.sing(name);
    }

    public static void main(String[] args) {
        LiRonHao liRonHao = new LiRonHao("李荣浩");
        liRonHao.issuance("《戒烟》");
    }
}
