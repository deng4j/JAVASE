package dzh.com.tools.hutools;

import cn.hutool.core.util.StrUtil;

public class StrUtilTest {
    public static void main(String[] args) {
        String s1 = "";
        String s2 = null;
        System.out.println(StrUtil.isBlank(s1));
        System.out.println(StrUtil.isBlank(s2));
        System.out.println(StrUtil.isEmpty(s1));
        System.out.println(StrUtil.isEmpty(s2));
    }
}
