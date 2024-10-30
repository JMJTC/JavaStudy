package designpattern.abstractfactorypattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-30
 * @Description: 抽象工厂模式
 * @Version: 1.0
 */


public class AbstractFactoryExample {
    public static void main(String[] args) {
        // 使用工厂1创建产品A1和产品B1
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();
        productA1.display();
        productB1.show();

        // 使用工厂2创建产品A2和产品B2
        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();
        productA2.display();
        productB2.show();
    }
}
//1.定义抽象产品
interface ProductA{
    void display();
}

interface ProductB{
    void show();
}

//2.实现具体产品类
class ConcreteProductA1 implements ProductA{
    @Override
    public void display(){
        System.out.println("Concrete Product A1");
    }
}

class ConcreteProductA2 implements ProductA{

    @Override
    public void display() {
        System.out.println("Concrete Product A2");
    }
}

class ConcreteProductB1 implements ProductB{

    @Override
    public void show() {
        System.out.println("Concrete Product B1");
    }
}

class ConcreteProductB2 implements ProductB{

    @Override
    public void show() {
        System.out.println("Concrete Product B2");
    }
}

//定义抽象工厂接口
interface AbstractFactory{
    ProductA createProductA();
    ProductB createProductB();
}

//实现具体工厂类
class ConcreteFactory1 implements AbstractFactory{

    @Override
    public ProductA createProductA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB1();
    }
}

class ConcreteFactory2 implements AbstractFactory{

    @Override
    public ProductA createProductA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ConcreteProductB2();
    }
}




