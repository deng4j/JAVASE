package JavaSE.com.Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern ：attern 对象是一个正则表达式的编译表示。
 *
 * Matcher ：Matcher 对象是对输入字符串进行解释和匹配操作的引擎。
 *
 * PatternSyntaxException ：非强制异常类，它表示一个正则表达式模式中的语法错误。
 */
public class Regex1 {

    public static void main(String[] args) {
        m5();
    }

    /**
     * appendReplacement(StringBuffer sb, String replacement)：实现非终端添加和替换步骤。
     *
     * appendTail(StringBuffer sb)：实现终端添加和替换步骤。
     */
    private static void m5() {
        String REGEX = "a*b";
        String INPUT = "aabfooaabfooabfoobkkk";
        String REPLACE = "-";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);

        StringBuffer sb = new StringBuffer();
        while(m.find()){
            m.appendReplacement(sb,REPLACE);
        }
        m.appendTail(sb);
        System.out.println(sb);
    }

    /**
     * replaceFirst 替换首次匹配
     * replaceAll 替换所有匹配
     */
    private static void m4() {
        String REGEX = "dog";
        String INPUT = "The dog says meow. All dogs say meow.";
        String REPLACE = "cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        //将dog替换成cat
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);
    }

    private static void m3() {
        //对单词 "cat" 出现在输入字符串中出现次数进行计数
        String REGEX = "\\bcat\\b";

        String INPUT = "cat cat cat cattie cat";

        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);
        int count = 0;

        while(m.find()) {
            count++;
            System.out.println("Match number "+count);
            //返回以前匹配的初始索引。
            System.out.println("start(): "+m.start());
            //返回最后匹配字符之后的偏移量。
            System.out.println("end(): "+m.end());
        }
    }

    private static void m1() {
        String content = "I am cxk from USA.";
        String pattern = ".*cxk.*";
        boolean matches = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'cxk' 子字符串? " + matches);
    }

    private static void m2() {
        // 按指定模式在字符串查找
        String line = "This order was placed for QT3000! OK?";
        String pattern = "(\\D*)(\\d+)(.*)";

        patternGroup(line, pattern);
    }

    /**
     * 捕获组：捕获组是把多个字符当一个单独单元进行处理的方法，它通过对括号内的字符分组来创建。
     *
     * 捕获组是通过从左至右计算其开括号来编号。例如，在表达式（（A）（B（C））），有四个这样的组：
     *   ((A)(B(C)))
     *   (A)
     *   (B(C))
     *   (C)
     *
     * 还有一个特殊的组（group(0)），它总是代表整个表达式。该组不包括在 groupCount 的返回值中。
     *
     * find()：尝试查找与该模式匹配的输入序列的下一个子序列。
     */
    public static void patternGroup(String line, String pattern) {
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            for (int i = 0; i <= m.groupCount(); i++) {
                System.out.println("Found value: " + m.group(i) );
            }
        } else {
            System.out.println("NO MATCH");
        }
    }

    /**
     * 全局匹配：Java里正则貌似不能像Js那样用【/g】全局匹配
     */
    public static void patternGroup_g(String line, String pattern) {
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);

        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        System.out.println("\033[32m" + "----------------------------------" + "\033[0m");
        while (m.find()) {
            System.out.println("Found value: " + m.group(0) );
        }
    }


}
