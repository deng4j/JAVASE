package dzh.com.JavaSE.com.characteristic.method.overload;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 谨慎使用重载，因为要调用哪个重载方法是在编译期决定的。
 */
public class CareFulUsing {

    public void classify(List<?> list){
        System.out.println("List:"+list);
    }

    public void classify(Collection<?> list){
        System.out.println("List:"+list);
    }

    public void classify(ArrayList<?> list){
        System.out.println("ArrayList:"+list);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ArrayList<String> list1 = new ArrayList<>();
        Collection<String> collection =new ArrayList<>();

        CareFulUsing careFulUsing = new CareFulUsing();
        careFulUsing.classify(list);
        careFulUsing.classify(list1);
        careFulUsing.classify(collection);
    }
}
