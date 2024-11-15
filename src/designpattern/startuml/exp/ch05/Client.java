package designpattern.startuml.exp.ch05;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-15
 * @Description: 适配器模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Chart circle = new Circle();
        circle.draw();
        Chart rectangle = new Rectangle();
        rectangle.draw();
        Chart line = new Line();
        line.draw();
        Angle angle = new Angle();
        Chart adapter = new Adapter(angle);
        adapter.draw();
    }
}


interface Chart{
    void draw();
}

class Circle implements Chart{
    @Override
    public void draw() {
        System.out.println("画圆");
    }
}

class Rectangle implements Chart{
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}

class Line implements Chart{
    @Override
    public void draw() {
        System.out.println("画直线");
    }
}

class Angle{
    public void drawAngle(){
        System.out.println("画角度");
    }
}

class Adapter implements Chart{
    private Angle angle;
    public Adapter(Angle angle){
        this.angle = angle;
    }
    @Override
    public void draw() {
        angle.drawAngle();
    }
}