package designpattern.startuml.exp.ch07;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-15
 * @Description: 装饰模式
 * @Version: 1.0
 */

public class Client {
    public static void main(String[] args) {
        Sheep basicSheep = new BasicSheep();
        System.out.println(basicSheep.run());
        basicSheep.loseLife();

        Sheep redAppleSheep = new RedAppleDecorator(basicSheep);
        System.out.println(redAppleSheep.run());

        Sheep greenAppleSheep = new GreenAppleDecorator(redAppleSheep);
        System.out.println(greenAppleSheep.run());
        greenAppleSheep.loseLife();

        Sheep yellowAppleSheep = new YellowAppleDecorator(greenAppleSheep);
        System.out.println(yellowAppleSheep.run());
    }
}

interface Sheep {
    String run();
    void loseLife();
}


class BasicSheep implements Sheep {
    private int lives = 5;

    @Override
    public String run() {
        return "喜羊羊正在奔跑";
    }

    @Override
    public void loseLife() {
        if (lives > 0) {
            lives--;
            System.out.println("喜羊羊失去了一条命，剩余：" + lives);
        }
    }

    public int getLives() {
        return lives;
    }
}


abstract class SheepDecorator implements Sheep {
    protected Sheep decoratedSheep;

    public SheepDecorator(Sheep decoratedSheep) {
        this.decoratedSheep = decoratedSheep;
    }

    public Sheep getDecoratedSheep() {
        return decoratedSheep;
    }
}


class RedAppleDecorator extends SheepDecorator {
    public RedAppleDecorator(Sheep decoratedSheep) {
        super(decoratedSheep);
    }

    @Override
    public String run() {
        return decoratedSheep.run() + "，红苹果保护罩";
    }

    @Override
    public void loseLife() {
        decoratedSheep.loseLife();
    }
}


class GreenAppleDecorator extends SheepDecorator {
    public GreenAppleDecorator(Sheep decoratedSheep) {
        super(decoratedSheep);
    }

    @Override
    public String run() {
        return decoratedSheep.run() + "，绿苹果加速激活";
    }
    @Override
    public void loseLife() {
        decoratedSheep.loseLife();
    }
}


class YellowAppleDecorator extends SheepDecorator {
    public YellowAppleDecorator(Sheep decoratedSheep) {
        super(decoratedSheep);
    }

    @Override
    public String run() {
        return decoratedSheep.run() + "，黄苹果蹚水激活";
    }
    @Override
    public void loseLife() {
        decoratedSheep.loseLife();
    }
}




