package designpattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 工厂方法模式
 * @Version: 1.0
 */

public class FactoryPattern {
    //工厂方法模式：定义一个创建对象的接口，让子类决定实例化哪一个类。工厂方法使一个类的实例化延迟到其子类。
    //工厂方法模式解决了简单工厂模式中工厂类职责过重的问题，工厂方法模式在简单工厂模式的基础上增加了抽象工厂角色，
    // 工厂方法模式中不再由一个工厂类统一创建所有产品对象，而是针对不同的产品提供不同的工厂，将工厂类与产品类解耦。
    //工厂方法模式的主要优点是增加新的产品类时，无需修改已有系统，并符合开闭原则，其缺点在于增加产品时需要对应增加产品工厂，
    // 系统类的个数将成倍增加，在一定程度上增加了系统的复杂度。
    //工厂方法模式适用情况包括：一个类不知道它所需要的对象的类；一个类通过其子类来指定创建哪个对象；将创建对象的任务委托给多个工厂子类中的某一个，
    // 而由工厂子类来确定实例化哪一个对象。
    //工厂方法模式的主要角色如下：
    //1.抽象工厂（Abstract Factory）：提供了创建产品的接口，调用者通过它访问具体工厂的工厂方法来创建产品。
    //2.具体工厂（Concrete Factory）：实现了抽象工厂接口，具体实现由工厂方法创建产品的实例。
    //3.抽象产品（Product）：定义了产品的规范，描述了产品的主要特性和功能。
    //4.具体产品（Concrete Product）：实现了抽象产品角色所定义的接口，由具体工厂创建，并实现具体业务逻辑。
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();

        ShapeFactory rectangleFactory = new RectangleFactory();
        Shape rectangle = rectangleFactory.createShape();
        rectangle.draw();
    }
}

//抽象产品
interface Shape{
    void draw();
}

//具体产品
class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("画一个圆形");
    }
}

//具体产品
class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("画一个矩形");
    }
}

//抽象工厂
interface ShapeFactory{
    Shape createShape();
}

//具体工厂
class CircleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

//具体工厂
class RectangleFactory implements ShapeFactory{
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
