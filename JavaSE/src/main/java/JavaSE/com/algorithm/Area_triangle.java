package JavaSE.com.algorithm;

public class Area_triangle {

    public static void main(String[] args) {
        m();
    }

    //求三角形面积
    static void m() {
        float a = 3, b = 4, c = 5;

        //海伦公式:p=(a+b+c)/2，S=sqrt[p(p-a)(p-b)(p-c)]
        float p = (a + b + c) / 2;
        Double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));

        System.out.println(S);
    }
}
