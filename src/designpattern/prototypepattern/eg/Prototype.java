package designpattern.prototypepattern.eg;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-08
 * @Description: 抽象原型类
 * @Version: 1.0
 */
public interface Prototype extends Cloneable {
    public Prototype clone() throws CloneNotSupportedException;
}


class ConcretePrototype1 implements Prototype {
    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class ConcretePrototype2 implements Prototype {
    @Override
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype = new ConcretePrototype1();
        Prototype clone = prototype.clone();
        // 这里可以进行判断，如果原型发生变化，则需要重新获取原型来创建对象
        // prototype = new ConcretePrototype2();
        // Prototype clone = prototype.clone();
    }
}


