package designpattern.startuml.exp.ch09;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-16
 * @Description: 观察者模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        ConcreteProduct product=new ConcreteProduct();

        ConcreteMember member1=new ConcreteMember("张三",product);
        ConcreteMember member2=new ConcreteMember("李四",product);
        ConcreteMember member3=new ConcreteMember("王五",product);
        product.addMember(member1);
        product.addMember(member2);
        product.addMember(member3);
        product.setProductName("IPhone 16");
        product.setProductPrice("6999");
        product.notifyAllMembers();
        System.out.println("=====================================");
        product.removeMember(member2);
        product.setProductPrice("5999");
        product.notifyAllMembers();

    }
}

abstract class Member {
    public abstract void update();
}

abstract class Product {
    private List<Member> members=new ArrayList<>();
    public abstract void addMember(Member member);
    public abstract void removeMember(Member member);
    public abstract String getProductName();
    public abstract String getProductPrice();
    public abstract void setProductName(String productName);
    public abstract void setProductPrice(String productPrice);
    public void notifyAllMembers(){
        for(Member member:members){
            member.update();
        }
    }
    public List<Member> getMembers(){
        return members;
    }

}

class ConcreteMember extends Member{
    private String name;
    private Product product;
    private String productName;
    private String productPrice;

    public ConcreteMember(String name, Product product) {
        this.name = name;
        this.product = product;
    }

    @Override
    public void update() {
        productName=product.getProductName();
        productPrice=product.getProductPrice();
        System.out.println(name+"收到产品信息更新，产品名称："+productName+"，产品价格："+productPrice);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
}

class ConcreteProduct extends Product{
    private String productName;
    private String productPrice;
    @Override
    public void addMember(Member member) {
        getMembers().add(member);
    }
    @Override
    public void removeMember(Member member) {
        getMembers().remove(member);
    }
    @Override
    public String getProductName() {
        return productName;
    }
    @Override
    public void setProductName(String productName) {
        this.productName = productName;
    }
    @Override
    public String getProductPrice() {
        return productPrice;
    }
    @Override
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

}
