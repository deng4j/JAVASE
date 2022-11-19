package JavaSE.com.oop.hotel;

import java.util.Date;

public class hotel {
    private  String name;
    private int number;
    private  String size;
    private  double price;
    private  Date start;

    public hotel() {
    }

    public hotel(String name, int number, String size, double price, Date start) {
        this.name = name;
        this.number = number;
        this.size = size;
        this.price = price;
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }
}
