package designpattern.startuml.exp.ch06;

import algorithm.contestlan.guo13.A;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-15
 * @Description: 桥接模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //定义三种口味
        Flavor milkFlavor=new MilkFlavor();
        Flavor sugerFlavor=new SugerFlavor();
        Flavor lemonFlavor=new LemonFlavor();


        AbstractCoffee coffee=new JorumCoffee(milkFlavor);
        coffee.operation();
        coffee=new MediumCoffee(sugerFlavor);
        coffee.operation();
        coffee=new SmallCoffee(lemonFlavor);
        coffee.operation();

    }
}

interface Flavor{
    void add();
}

class MilkFlavor implements Flavor{
    @Override
    public void add() {
        System.out.println("加牛奶");
    }
}

class SugerFlavor implements Flavor{
    @Override
    public void add() {
        System.out.println("加糖");
    }
}

class LemonFlavor implements Flavor{
    @Override
    public void add() {
        System.out.println("加柠檬");
    }
}

abstract class AbstractCoffee{
    protected Flavor flavor;
    public AbstractCoffee(Flavor flavor){
        this.flavor=flavor;
    }
    public abstract void operation();
}

class JorumCoffee extends AbstractCoffee{
    public JorumCoffee(Flavor flavor) {
        super(flavor);
    }

    @Override
    public void operation() {
        System.out.println("制作大杯咖啡");
        flavor.add();
    }
}

class MediumCoffee extends AbstractCoffee{
    public MediumCoffee(Flavor flavor){
        super(flavor);
    }

    @Override
    public void operation() {
        System.out.println("制作中杯咖啡");
        flavor.add();
    }
}

class SmallCoffee extends  AbstractCoffee{
    public SmallCoffee(Flavor flavor){
        super(flavor);
    }

    @Override
    public void operation() {
        System.out.println("制作小杯咖啡");
        flavor.add();
    }
}