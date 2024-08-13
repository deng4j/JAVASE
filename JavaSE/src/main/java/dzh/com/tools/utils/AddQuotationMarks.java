package dzh.com.tools.utils;

// 给数据列添加引号和逗号
public class AddQuotationMarks {
    public static void main(String[] args) {
        String data = "0002112658\n" +
                "0002112658\n" +
                "0002112658\n";

        StringBuilder newdata = new StringBuilder();
        String[] strings = data.split("\n");

        for (String string : strings) {
            newdata.append("\'"+string+"\',");
        }
        System.out.println(newdata);
    }
}
