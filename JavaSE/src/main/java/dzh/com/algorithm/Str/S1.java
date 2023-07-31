package dzh.com.algorithm.Str;

import java.util.*;

/**
 * 写一个算法，两个字符串比较，如：abcdefg,25abdfxx
 * 返回：
 * 位置0多出:25
 * 位置2缺少:c
 * 位置4缺少:e
 * 位置6错误，应为:g
 */
public class S1 {
    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "25abdfxx";

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        List<Character> list1 = new ArrayList<>();
        for (char c : chars1) {
            list1.add(c);
        }
        List<Character> list2 = new ArrayList<>();
        for (char c : chars2) {
            list2.add(c);
        }
        StringBuilder log = new StringBuilder();

        // 判断头部有无多出
        int i1 = s2.indexOf(chars1[0]);
        if (i1>0){
            log.append("位置"+0+"多出："+s2.substring(0,i1));
            log.append("\n");
            for (int i = 0; i < i1; i++) {
                list2.remove(0);
            }
        }

        //[a, b, c, d, e, f, g]
        //[a, b, d, f, x, x]
        int index1 = 0;
        int index2 = 0;
        for (int i = index1; i < list1.size()-1; i++) {
            for (int j = index2; j < list2.size(); j++) {
                if (list1.get(i)==list2.get(j)){
                    if (i==j){
                        index1++;
                        index2++;
                        break;
                    }
                    if (i>j){
                        index2++;
                        break;
                    }
                } else if (j== list2.size()-1) {
                    log.append("位置"+i+"缺少："+list1.get(i));
                    log.append("\n");
                }
            }
        }

        // 末尾判断
        if (list1.get(list1.size()-1) !=list2.get(index2)){
            log.append("位置"+(list1.size()-1)+"应该是："+list1.get(list1.size()-1));
            log.append("\n");
        }

        System.out.println(log);
    }
}
