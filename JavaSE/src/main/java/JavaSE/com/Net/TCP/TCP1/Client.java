package JavaSE.com.Net.TCP.TCP1;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //创建客户端+端口
        Socket client = new Socket("localhost", 9000);

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        Scanner scanner = new Scanner(System.in);
        String str = null;
        System.out.println("请输入");
        while (true) {
            str = scanner.nextLine();
            int i = 0;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {

            }
            if (i == 886) {
                break;
            }
            bw.write(str);
            //给服务器一个结束符
            bw.newLine();
            bw.flush();
            //读
            String readed = br.readLine();
            System.out.println(readed);
        }

        //关流的时候多写一个服务器结束标记
        bw.close();
        //释放
        client.close();
    }
}
