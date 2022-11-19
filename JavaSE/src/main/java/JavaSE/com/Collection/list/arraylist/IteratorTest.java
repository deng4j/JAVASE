package JavaSE.com.Collection.list.arraylist;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("def");
        list.add("def");
        list.add("aa");
        list.add("def");

        Iterator<String> i=list.iterator();
        while (i.hasNext()){
            String s=i.next();
            if (s.equals("def")){
                i.remove();
                continue;
            }
        }
        for (int i1 = 0; i1 < list.size(); i1++) {
            System.out.println(list.get(i1));
        }
    }
}
