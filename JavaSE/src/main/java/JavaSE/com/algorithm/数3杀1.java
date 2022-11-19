package JavaSE.com.algorithm;

import java.util.ArrayList;
import java.util.List;

public class 数3杀1 {
    public static void main(String[] args) {
        int n=7;

        List<Integer> list=new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        int last=0;
        while (list.size()>3){
            if (last%3==0||list.size()==n){
                for (int i = 2; i < list.size(); i+=2) {
                    list.remove(i);
                    last=list.size()-i;
                }
            }else if (last%3==1){
                for (int i = 1; i < list.size(); i+=2) {
                    list.remove(i);
                    last=list.size()-i;
                }
            }else if (last%3==2){
                for (int i = 0; i < list.size(); i+=2) {
                    list.remove(i);
                    last=list.size()-i;
                }
            }

        }
        System.out.println(list);
    }
}
