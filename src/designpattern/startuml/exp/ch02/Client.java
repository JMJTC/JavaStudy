package designpattern.startuml.exp.ch02;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-13
 * @Description: 工厂模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        ComputerFactory factory=new HPComputerFactory();
        Computer hp=factory.createComputer();
        hp.produce();

        factory=new AcerComputerFactory();
        Computer acer=factory.createComputer();
        acer.produce();

        factory=new LenovoComputerFactory();
        Computer lenovo=factory.createComputer();
        lenovo.produce();

        factory=new DellComputerFactory();
        Computer dell=factory.createComputer();
        dell.produce();
    }
}

//抽象产品
interface Computer {
    void produce();
}

//具体产品
class HPComputer implements Computer {

    @Override
    public void produce() {
        System.out.println("HPComputer");
    }
}

class AcerComputer implements Computer {
    @Override
    public void produce() {
        System.out.println("AcerComputer");
    }
}

class LenovoComputer implements Computer {
    @Override
    public void produce() {
        System.out.println("LenovoComputer");
    }
}

class DellComputer implements Computer {
    @Override
    public void produce() {
        System.out.println("DellComputer");
    }
}

//抽象工厂
interface ComputerFactory{
    Computer createComputer();
}

//具体工厂
class HPComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer(){
        return new HPComputer();
    }
}

class AcerComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer(){
        return new AcerComputer();
    }
}

class DellComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer(){
        return new DellComputer();
    }
}

class LenovoComputerFactory implements ComputerFactory{
    @Override
    public Computer createComputer(){
        return new LenovoComputer();
    }
}
