package dzh.com.JavaSE.com.base.baseType.strings;

public class ToLowerFirstCase {

    public static void main(String[] args) {
        String tableName = m1();
        m2(tableName);
    }

    private static void m2(String tableName) {
        String lowerFirstCase = toLowerFirstCase(tableName);
        System.out.println(lowerFirstCase);
    }

    private static String m1() {
        String tableName="tb_user_name";
        StringBuilder reTableName=new StringBuilder();
        int i = tableName.indexOf("_");
        String[] split = tableName.split("_");
        for (int j = 0; j < split.length; j++) {
            reTableName.append(toUpFirstCase(split[j]));
        }
        System.out.println(reTableName);

        return reTableName.toString();
    }

    public static String toUpFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        if (chars[0]<=122&&chars[0]>=97){
            chars[0] -=32;
        }
        return String.valueOf(chars);
    }

    private static String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        //大小写字母ASCII码相差32
        if (chars[0]>=65&&chars[0]<=90){
            //说明是一个大写字母
            chars[0] +=32;
        }
        return String.valueOf(chars);
    }
}
