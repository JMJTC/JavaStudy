package designpattern.brigepattern.eg;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-18
 * @Description: 桥接模式的简易实现
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TV aTV = new ATV();
        TV bTV = new BTV();

        TVAbstraction basicTV1=new RefinedTVAbstraction(aTV);
        TVAbstraction basicTV2=new RefinedTVAbstraction(bTV);
        basicTV1.on();
        basicTV1.off();
        basicTV1.tuneChannel();

        basicTV2.on();
        basicTV2.off();
        basicTV2.tuneChannel();
    }
}

//1.创建实现接口
interface Implementation {
    void operationImpl();
}

//以电视举例
interface TV {
    void on();
    void off();
    void tuneChannel();
}

//2.创建具体实现：实际提供服务的对象。
class ConcreteImplementationA implements Implementation {
    @Override
    public void operationImpl() {
        // 具体实现A
    }
}
class ConcreteImplementationB implements Implementation {
    @Override
    public void operationImpl() {
        // 具体实现B
    }
}

//以电视举例，创建具体实现类
class ATV implements TV {
    @Override
    public void on() {
        System.out.println("A TV is ON");
    }

    @Override
    public void off() {
        System.out.println("A TV is OFF");
    }

    @Override
    public void tuneChannel() {
        System.out.println("Tuning A TV channel");
    }
}


class BTV implements TV {
    @Override
    public void on() {
        System.out.println("B TV is ON");
    }

    @Override
    public void off() {
        System.out.println("B TV is OFF");
    }

    @Override
    public void tuneChannel() {
        System.out.println("Tuning B TV channel");
    }
}

//3.创建抽象接口：包含一个对实现化接口的引用
abstract class Abstraction {

    protected Implementation mImplementor;

    public Abstraction(Implementation implementor) {
        this.mImplementor = implementor;
    }

    public void operation() {
        this.mImplementor.operationImpl();
    }
}


//以电视为例
abstract class TVAbstraction {
    protected TV tv;
    public TVAbstraction(TV tv) {
        this.tv = tv;
    }
    abstract public void on();
    abstract public void off();
    abstract public void tuneChannel();
}

//4.实现抽象接口
class RefinedTVAbstraction extends TVAbstraction {
    public RefinedTVAbstraction(TV tv) {
        super(tv);
    }
    @Override
    public void on() {
        tv.on();
    }
    @Override
    public void off() {
        tv.off();
    }
    @Override
    public void tuneChannel() {
        tv.tuneChannel();
    }
}

