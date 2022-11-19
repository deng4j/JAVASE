package JavaSE.com.String;

public class RandomStr {

    public static void main(String[] args) {

        //需要生成几位
        int n = 10;
        //最终生成的字符串
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char)(Math.random()*26+97));
        }
        System.out.println(sb);
    }
}
