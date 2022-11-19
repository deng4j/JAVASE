package JavaSE.com.println;

public class Color {
    public static void main(String[] args){
        System.out.println("Hello,Akina1");
        System.out.println("\033[30;4m" + "Hello,Akina2" + "\033[0m");
        System.out.println("\033[31;4m" + "Hello,Akina3" + "\033[0m");
        System.out.println("\033[32;4m" + "Hello,Akina4" + "\033[0m");
        System.out.println("\033[33;4m" + "Hello,Akina5" + "\033[0m");
        System.out.println("\033[34;4m" + "Hello,Akina6" + "\033[0m");
        System.out.println("\033[35;4m" + "Hello,Akina7" + "\033[0m");
        System.out.println("\033[36;4m" + "Hello,Akina8" + "\033[0m");
        System.out.println("\033[37;4m" + "Hello,Akina9" + "\033[0m");
        System.out.println("\033[40;31;4m" + "Hello,Akina10" + "\033[0m");
        System.out.println("\033[41;32;4m" + "Hello,Akina11" + "\033[0m");
        System.out.println("\033[42;33;4m" + "Hello,Akina12" + "\033[0m");
        System.out.println("\033[43;34;4m" + "Hello,Akina13" + "\033[0m");
        System.out.println("\033[44;35;4m" + "Hello,Akina14" + "\033[0m");
        System.out.println("\033[45;36;4m" + "Hello,Akina15" + "\033[0m");
        System.out.println("\033[46;37;4m" + "Hello,Akina16" + "\033[0m");
        System.out.println("\033[47;4m" + "Hello,Akina17" + "\033[0m");

        System.out.println("\033[30m" + "酱紫1");
        System.out.println("\033[31m" + "酱紫2");
        System.out.println("\033[32m" + "酱紫3");
        System.out.println("\033[32m" + "酱紫3.1" + "\033[0m");
        System.out.println("\033[37m" + "酱紫4");

        System.out.println("\033[43m" + "酱紫5");
        System.out.println("\033[44m" + "酱紫6"+"\033[m");
        System.out.println("\033[45m" + "酱紫7");
        System.out.println("\033[46m" + "酱紫8"+"\033[m");

        //1:加粗,;:隔开,90~97字体颜色变亮
        System.out.println("\033[1;90m" + "酱紫9");
        System.out.println("\033[1;94m" + "酱紫10");
        System.out.println("\033[1;95m" + "酱紫11");
        System.out.println("\033[1;97m" + "酱紫12");
        System.out.println("\033[1;93;45m" + "酱紫13"+"\033[m");
    }
}
