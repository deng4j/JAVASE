package dzh.com.JavaSE.com.base.baseType.strings;

import java.text.DecimalFormat;
import java.util.Locale;

public class Format {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.######");
        String str = df.format(Double.parseDouble("12.111222333444"));
        System.out.println(str);

        System.out.println(String.format("Hi，%s", "中国"));
    }
}
