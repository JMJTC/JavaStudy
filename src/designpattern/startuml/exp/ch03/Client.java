package designpattern.startuml.exp.ch03;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-13
 * @Description: 抽象工厂模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建具体工厂
        Factory kfcFactory=new KFCFactory();
        //定义产品族对象
        AbstractHamburg hamburg= kfcFactory.createHamburg();
        hamburg.display();
        AbstractCola cola=kfcFactory.createCola();
        cola.display();

        Factory mcDonaldsFactory=new McDonaldsFactory();
        hamburg= mcDonaldsFactory.createHamburg();
        hamburg.display();
        cola=mcDonaldsFactory.createCola();
        cola.display();

    }
}

interface AbstractHamburg{
    void display();
}

class HamburgA implements AbstractHamburg{
    @Override
    public void display(){
        System.out.println("KFC's Hamburg");
    }
}

class HamburgB implements AbstractHamburg{
    @Override
    public void display(){
        System.out.println("McDonalds's Hamburg");
    }
}

interface AbstractCola{
    void display();
}

class ColaA implements AbstractCola{
    @Override
    public void display(){
        System.out.println("KFC's Cola");
    }
}

class ColaB implements AbstractCola{
    @Override
    public void display(){
        System.out.println("McDonalds's Cola");
    }
}

interface Factory{
    AbstractHamburg createHamburg();
    AbstractCola createCola();
}

class KFCFactory implements Factory{
    @Override
    public AbstractHamburg createHamburg(){
        return new HamburgA();
    }
    @Override
    public AbstractCola createCola(){
        return new ColaA();
    }
}

class McDonaldsFactory implements Factory{
    @Override
    public AbstractHamburg createHamburg(){
        return new HamburgB();
    }
    @Override
    public AbstractCola createCola(){
        return new ColaB();
    }
}


