package dzh.com.JavaSE.com.base.strings;

/**
 * 找到字符串第一个位置的索引，如果不存在返回-1
 */
public class IndexOf {
    public static void main(String[] args) {
        String s1 = "111aaaabcccbddd";
        int index = s1.indexOf("b");
        System.out.println(index);
    }
}
