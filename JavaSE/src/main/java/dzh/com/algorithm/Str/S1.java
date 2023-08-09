package dzh.com.algorithm.Str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        m1();
    }

    public static String mySubstring(String s, int startIndex, int endIndex, int endLength) {
        return s.substring(startIndex + 1, endIndex);
    }

    /**
     * 这个算法当例子是 11abcdefgab、25axxbdxgcb 会得到人脑不想要的结果
     * 解决办法，相似性算法
     */
    private static void m1() {
        String s1 = "11abcdefgab";
        String s2 = "25axxbdxgb";
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int index2 = 0;
        int m1 = -1; // char1的记忆指针
        int m2 = -1; // char2的记忆指针
        for (int i = 0; i < chars1.length; i++) {
            for (int j = index2; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    String subS1 = mySubstring(s1, m1, i, chars1.length);
                    String subS2 = mySubstring(s2, m2, j, chars2.length);
                    if (subS1.isEmpty() && !subS2.isEmpty()) {
                        System.out.println("位置" + i + "多出：" + subS2);
                    }
                    if (!subS1.isEmpty() && !subS2.isEmpty()) {
                        for (int k = i - subS1.length(); k < i; k++) {
                            System.out.println("位置" + k + "应该是：" + chars1[k]);
                        }
                    }
                    if (!subS1.isEmpty() && subS2.isEmpty()) {
                        for (int k = i - subS1.length(); k < i; k++) {
                            System.out.println("位置" + k + "缺少：" + chars1[k]);
                        }
                    }
                    m1 = i;
                    m2 = j;
                    index2 = j;
                    break;
                }
            }
        }
        // 处理末尾
        if (chars1.length - 1 == m1) {
            if (chars2.length - 1 != m2) {
                System.out.println("位置" + (m1 + 1) + "多出：" + s2.substring(m2 + 1, chars2.length));
            }
        } else {
            // 说明后面还有一串
            for (int i = m1 + 1; i < chars1.length; i++) {
                if (chars2.length - 1 != m2) {
                    System.out.println("位置" + (i) + "应该是：" + chars1[i]);
                } else {
                    System.out.println("末尾位置" + (i) + "缺少：" + chars1[i]);
                }
            }
        }
    }

    /**
     * 相似度匹配
     */
    private static void m2() {
        String s1 = "11abcdefgab";
        String s2 = "25axxbdxgcb";
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        Map<Integer, List<Integer>> similarMap = new HashMap<>();

        // 命中
        for (int i = 0; i < chars1.length; i++) {
            List<Integer> list =new ArrayList<>();
            similarMap.put(i,list);
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    list.add(j);
                }
            }
        }
        System.out.println(similarMap);
        // 相似度匹配
        Map<Integer, Integer> matchMap = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : similarMap.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> list = entry.getValue();
            if (list.isEmpty()){
                matchMap.put(key,null);
                break;
            }
        }


    }
}
