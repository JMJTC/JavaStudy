package designpattern.abstractfactorypattern;

import java.util.Scanner;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-30
 * @Description: 家具工厂
 * @Version: 1.0
 */


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
//        sc.nextLine();
        for(int i=0;i<n;i++){
            String str=sc.next();
            AbstractFurnitureFactory factory;
            if("modern".equals(str)){
                factory=new ModernFactory();
                Product sofa= factory.createSofa();
                Product chair=factory.createChair();
                chair.display();
                sofa.display();
            }else if("classical".equals(str)){
                factory=new ClassicalFactory();
                Product sofa= factory.createSofa();
                Product chair=factory.createChair();
                chair.display();
                sofa.display();
            }
        }
    }
}

interface Product{
    void display();
}

//定义抽象产品 现代&&古典
interface ModernProduct extends Product{

}

interface ClassicalProduct extends Product{

}

//沙发&&椅子
class ModernSofa implements ModernProduct {
    @Override
    public void display() {
        System.out.println("modern sofa");
    }
}

class ModernChair implements ModernProduct {
    @Override
    public void display() {
        System.out.println("modern chair");
    }
}

class ClassicalSofa implements ClassicalProduct {
    @Override
    public void display() {
        System.out.println("classical sofa");
    }
}

class ClassicalChair implements ClassicalProduct {
    @Override
    public void display() {
        System.out.println("classical chair");
    }
}

interface AbstractFurnitureFactory{
    Product createChair();
    Product createSofa();
}

class ModernFactory implements AbstractFurnitureFactory{

    @Override
    public Product createChair() {
        return new ModernChair();
    }

    @Override
    public Product createSofa() {
        return new ModernSofa();
    }
}

class ClassicalFactory implements AbstractFurnitureFactory{

    @Override
    public Product createChair() {
        return new ClassicalChair();
    }

    @Override
    public Product createSofa() {
        return new ClassicalSofa();
    }
}