package dzh.com.JavaSE.com.base;

import java.util.ArrayList;
import java.util.List;

public class Field_method {
    private List<Integer> list = new ArrayList<>(List.of(0,1));
    private Integer size = list.size();
    private Integer one = getOne();

    private Integer getOne(){
        return list.get(0);
    }

    public void set(Integer e){
        list.add(e);
    }

    public static void main(String[] args) {
        Field_method fm = new Field_method();
        fm.set(4);

        System.out.println(fm.size);
        System.out.println(fm.one);
        System.out.println(fm.list);
    }

}
