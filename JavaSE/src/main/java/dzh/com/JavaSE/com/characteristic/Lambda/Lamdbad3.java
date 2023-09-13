package dzh.com.JavaSE.com.characteristic.Lambda;

import dzh.com.JavaSE.com.characteristic.Lambda.utils.LambdaUtils;

public class Lamdbad3 {

    public static void main(String[] args) {
        System.out.println(LambdaUtils.convertToFieldName(User::getName));
    }
}


class User{
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
