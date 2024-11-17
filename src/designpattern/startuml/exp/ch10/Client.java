package designpattern.startuml.exp.ch10;

import algorithm.contestlan.guo13.B;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-17
 * @Description: 策略模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Discount computerDiscount=new ComputerDiscount();
        Discount englishDiscount=new EnglishDiscount();

        BookSale book=new BookSale();
        double price=60.0;
        book.setPrice(60.0);
        book.setDiscount(computerDiscount);
        double finalPrice=book.getPrice();
        System.out.println("计算机图书的原始票价："+price);
        System.out.println("折扣票价："+finalPrice);

        System.out.println("===============================");
        book.setDiscount(englishDiscount);
        finalPrice=book.getPrice();
        System.out.println("英语图书的原始票价："+price);
        System.out.println("折扣票价："+finalPrice);

    }
}

interface Discount{
    double calculateDiscount(double price);
}

class ComputerDiscount implements Discount{
    @Override
    public double calculateDiscount(double price){
        return price*0.7;
    }
}

class EnglishDiscount implements Discount{

    @Override
    public double calculateDiscount(double price) {
        return price*0.6;
    }
}

class BookSale{
    private Discount discount;
    private double price;

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return discount.calculateDiscount(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }
}