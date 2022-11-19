package JavaSE.com.String;

public class StringTokenizer {
    public static void main(String[] args) {
        String str="name=";
        java.util.StringTokenizer stringTokenizer=new java.util.StringTokenizer(str,"\\=");
        while (stringTokenizer.hasMoreTokens()){
            String s = stringTokenizer.nextToken();
            System.out.println(s);
        }

        System.out.println((char)97);
    }
}
