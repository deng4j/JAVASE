package dzh.com.JavaSE.com.Regex;

/**
 * 两个正则的区别在于转义字符，Java使用的是\\，JavaScript使用的是\
 *  Java里正则貌似不能像Js那样用【/g】全局匹配
 */
public class RegexGrammar1 {

    public static void main(String[] args) {

    }

    private static void m7() {
        String str="ytyj 154_";
        //匹配字母、数字、下划线。等价于 [A-Za-z0-9_]
        String patt="\\w";

        Regex1.patternGroup_g(str,patt);
    }

    private static void m6() {
        String str="ytyj\n \r";
        // 匹配所有。\s 是匹配所有空白符，包括换行，\S 非空白符，不包括换行。
        String patt="[\\s\\S]";

        Regex1.patternGroup_g(str,patt);
    }

    private static void m5() {
        String str="ytyj\n \r";
        //匹配除换行符（\n、\r）之外的任何单个字符，相等于 [^\n\r]。
        String patt=".";

        Regex1.patternGroup_g(str,patt);
    }

    private static void m4() {
        String str="HFiixL";
        //匹配A-Z的大写字符
        String patt1="[A-Z]";
        Regex1.patternGroup_g(str,patt1);

        //匹配a-z的小写字符
        String patt2="[a-z]";
        Regex1.patternGroup_g(str,patt2);
    }

    private static void m3() {
        String str="ytyj egiuh密okuujbh";
        //匹配不是[]集合中的字符
        String patt="[^ae i密ou]";

        Regex1.patternGroup_g(str,patt);
    }

    private static void m2() {
        String str="ytyj egiuh密okuujbh";
        //匹配[]集合中的字符
        String patt="[ae i密ou]";

        Regex1.patternGroup_g(str,patt);
    }

    private static void m1() {
        String str = "1234abc";
        //以0-9的零个或多个数字开头，abc结尾的数字
        String patt = "^[0-9]+abc$";

        Regex1.patternGroup(str,patt);
    }
}
