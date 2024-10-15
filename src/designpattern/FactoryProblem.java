package designpattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 积木工厂
 * @Version: 1.0
 */
public class FactoryProblem {
    public static void main(String[] args) {

    }
}

interface BlockShape{
    void draw();
}

class Circle1 implements BlockShape{
    @Override
    public void draw() {
        System.out.println("画圆");
    }
}

class Square implements BlockShape{
    @Override
    public void draw() {
        System.out.println("画正方形");
    }
}

interface BlockFactory{
    BlockShape create();
}

class Circle1Factory implements BlockFactory{
    @Override
    public BlockShape create() {
        return new Circle1();
    }
}

class SquareFactory implements BlockFactory{
    @Override
    public BlockShape create() {
        return new Square();
    }
}


