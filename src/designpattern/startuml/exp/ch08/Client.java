package designpattern.startuml.exp.ch08;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-16
 * @Description: 外观模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.activate();
        facade.deactivate();
    }
}

class Camera{
    public void on(){
        System.out.println("录像机开启");
    }
    public void off(){
        System.out.println("录像机关闭");
    }
}

class Light{
    public void on(){
        System.out.println("灯光开启");
    }
    public void off(){
        System.out.println("灯光关闭");
    }
}

class Sensor{
    public void active(){
        System.out.println("感应器激活");
    }
    public void deactivate(){
        System.out.println("感应器关闭");
    }
}

class Alarm{
    public void active(){
        System.out.println("警报器激活");
    }
    public void deactivate(){
        System.out.println("警报器关闭");
    }
}

class Facade{
    private Camera camera;
    private Light light;
    private Sensor sensor;
    private Alarm alarm;
    public Facade(){
        camera = new Camera();
        light = new Light();
        sensor = new Sensor();
        alarm = new Alarm();
    }
    public void activate(){
        camera.on();
        light.on();
        sensor.active();
        alarm.active();
    }
    public void deactivate(){
        camera.off();
        light.off();
        sensor.deactivate();
        alarm.deactivate();
    }
}