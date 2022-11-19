package JavaSE.com.oop.hotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class admin {


    public static void add(ArrayList<hotel> list ) throws ParseException {
        double price=0;
        Scanner scanner=new Scanner(System.in);
            System.out.println("请输入姓名");
            String name=scanner.next();
            System.out.println("请选择房间大小");
            String size;
            lo:while (true) {
                String  size1=scanner.next();
                switch (size1) {
                    case "单人间":
                        price = 100.0;
                        size=size1;
                        break lo;
                    case "双人间":
                        price = 150.0;
                        size=size1;
                        break lo;
                    case "豪华套房":
                        price = 500.0;
                        size=size1;
                        break lo;
                    default:
                        System.out.println("请重新选择");
                        break;
                }
            }

        Date start=new Date();


        int number= (int) ((Math.floor( 1+Math.random()*4))*100 + (Math.floor(Math.random()*3))*10+(Math.floor(Math.random()*8)));
        hotel hotel=new hotel(name,number,size,price,start);
        list.add(hotel);
            for (int i=0;i<list.size()-1;i++){
                int numberb= (int) ((Math.floor( 1+Math.random()*4))*100 + (Math.floor(Math.random()*3))*10+(Math.floor(Math.random()*8)));
                if (list.get(i).getNumber()==number){
                    System.out.println(number+"房间已满");
                    list.get(list.size()-1).setNumber(numberb);
                }
            }


        }

        public  static  void getinfo(ArrayList<hotel> list){
            System.out.println("请输入姓名 或按2查看全部");
            Scanner scanner=new Scanner(System.in);
            String name=scanner.next().trim();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            for (int i=0;i<list.size();i++){
                if ( list.get(i).getName()!=null&& list.get(i).getName().equals(name)){
                    System.out.println("姓名："+ list.get(i).getName()+" 房间类型："+list.get(i).getSize()+" 房间号："
                            +list.get(i).getNumber()+" 入住时间："+dateFormat.format(list.get(i).getStart()) );
                    break;
                }else if ( name.equals("2")){ //bug: integer.parseInt(name)==2 Integer是一个引用类型
                    System.out.println("姓名："+ list.get(i).getName()+" 房间类型："+list.get(i).getSize()+" 房间号："
                            +list.get(i).getNumber()+" 入住时间："+dateFormat.format(list.get(i).getStart()) );

                }else if (i==list.size()-1){
                    System.out.println("查无此人");
                }
            }
        }
        public  static  void  setroom(ArrayList<hotel> list){
            Scanner scanner=new Scanner(System.in);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("请输入姓名");
                String name=scanner.next();
                System.out.println("请输入房间号");
                int number=scanner.nextInt();
                if (name!=null&& list.get(i).getName().equals(name)&&list.get(i).getNumber()==number){
                    System.out.println("输入房间类型");
                    String size=scanner.next();
                    list.get(i).setSize(size);
                    break;
                }else if (i==list.size()-1){
                    System.out.println("查无此人");
                }
            }
        }

        public static  void checkout(ArrayList<hotel> list){
            Scanner scanner=new Scanner(System.in);
            for (int i = 0; i < list.size(); i++) {
                System.out.println("请输入姓名");
                String name=scanner.next();
                System.out.println("请输入房间号");
                int number=scanner.nextInt();
                Date end=new Date();
                if (name!=null&& list.get(i).getName().equals(name)&&list.get(i).getNumber()==number){
                       Date start=list.get(i).getStart();
                    long Tstart = start.getTime();
                    long Tend = end.getTime();
                    int hour = (int) ((Tend - Tstart) / (1000 * 60*60));
                    switch (list.get(i).getSize()){
                        case "豪华套房":
                            System.out.println("费用："+(hour*50)+"￥");
                            break;
                        case "单人间":
                            System.out.println("费用："+(hour*15)+"￥");
                            break;
                        case "双人间":
                            System.out.println("费用："+(hour*25)+"￥");
                            break;
                         default:
                             System.out.println("bug");
                             break;
                    }

                    break;
                }else if (i==list.size()-1){
                    System.out.println("查无此人");
                }
            }
        }

        public static void input() throws ParseException {
            ArrayList<hotel> list=new ArrayList();

            Scanner scanner=new Scanner(System.in);
           lo: while (true){
               System.out.println("按1开房，2查看入住信息，3修改套房，4退房，5退出系统");
                int input=scanner.nextInt();
                switch (input){
                    case 1:
                        System.out.println("开房");
                        add(list);
                        break;
                    case 2:
                        System.out.println("查看入住信息");
                        getinfo(list);
                        break;
                    case 3:
                        System.out.println("修改入住信息");
                        setroom(list);
                        break;
                    case 4:
                        System.out.println("退房");
                        checkout(list);
                        break;
                    case 5:
                        System.out.println("退出系统");
                        break lo;
                }
            }

        }

    public static void main(String[] args) throws ParseException {
        input();
    }

    }


