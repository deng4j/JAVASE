package dzh.com.DesignPattern.DesignPattern.mediator;

import java.util.HashMap;

public class President implements Mediator {
    private HashMap<String,Department> map=new HashMap<>();

    @Override
    public void register(String dname, Department department) {
        map.put(dname,department);
    }

    @Override
    public void commend(String dname) {
        map.get(dname).selfAction();
    }
}
