package JavaSE.com.extend.extend1;

public class server extends employee {
    private  int Sara;

    private  String name;

    public int getSara() {
        return Sara;
    }

    public void setSara(int sara) {
        Sara = sara;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        super.work();
        System.out.println(getName()+"修脚"+Sara);
    }



    public static void main(String[] args) {
        server server=new server();
        server.setName("张三");
        server.setSara(20000);
        System.out.println(server);
        server.work();
    }
}
