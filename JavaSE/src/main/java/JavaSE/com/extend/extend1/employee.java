package JavaSE.com.extend.extend1;

public class employee {
    private String id;
    private  String name;

    public employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  void work(){
        System.out.println(name+"干活");
    }
}
