package JavaSE.com.Collection.cards;

import java.util.*;

public class CardApp1 {
    public static void main(String[] args) {
        HashMap<Integer, String> total = total();
        Comparator<String> comparator=(String s1,String s2)->{
            String ss1 = s1.substring(1);
            String ss2 = s2.substring(1);
            int result = 0;
            int p1=0;
            int p2=0;
            try {
                 p1 = Integer.parseInt(ss1);
                 p2 = Integer.parseInt(ss2);
                 result=p1-p2;
            } catch (NumberFormatException e) {
                if (p1==0){
                    result=1;
                }else if (p1!=0&&p2==0){
                    result=-1;
                }else {
                    result=0;
                }
            }
            return  result==0?s1.compareTo(s2):result;
        };
        TreeSet<String> u1=new TreeSet<>(comparator);
        TreeSet<String> u2=new TreeSet<>(comparator);
        TreeSet<String> u3=new TreeSet<>(comparator);
        TreeSet<String> lastpork=new TreeSet<>(comparator);
        for (int i = 0; i < 51; i+=3) {
            u1.add(total.get(i));
            u2.add(total.get(i+1));
            u3.add(total.get(i+2));
        }
        lastpork.add(total.get(51));
        lastpork.add(total.get(52));
        lastpork.add(total.get(53));

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println("底牌"+lastpork);
    }
    private static HashMap<Integer,String> total() {
        HashMap<Integer,String> map=new HashMap<>();
        List<String> go=new ArrayList<>(List.of("A","2","3","4","5","6","7","8","9","10","J","Q","K"));
        ArrayList<String> color=new ArrayList<>(List.of("♣","♥","■","♠"));
        ArrayList<String> col=new ArrayList<>();
        for (String s : go) {
            for (String s1 : color) {
                col.add(s1+s);
            }
        }
        col.add("大王");
        col.add("小王");
        Collections.shuffle(col);
        for (int i = 0; i < col.size(); i++) {
            map.put(i,col.get(i));
        }
        return map;
    }
}
