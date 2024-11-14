package designpattern.startuml.exp.ch04;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-14
 * @Description: 建造者模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建建造者
        Builder builder1 = new BMWBuilder();
        Builder builder2 = new BenZBuilder();
        //指挥者
        Director director = new Director(builder1);
        //指挥者创建产品
        Car car = director.construct();
        System.out.println(car.toString());

        director.setBuilder(builder2);
        Car car2 = director.construct();
        System.out.println(car2.toString());
    }
}

class Car{
    private String wheel;
    private String oilBox;
    private String body;

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        this.wheel = wheel;
    }

    public String getOilBox() {
        return oilBox;
    }

    public void setOilBox(String oilBox) {
        this.oilBox = oilBox;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Car(String wheel, String oilBox, String body) {
        this.wheel = wheel;
        this.oilBox = oilBox;
        this.body = body;
    }

    public Car() {
    }

    @Override
    public String toString(){
        return "wheel:"+wheel+"  "+"oilBox:"+oilBox+"   "+"body:"+body;
    }
}

interface Builder{
    void buildWheel();
    void buildOilBox();
    void buildBody();
    Car buildCar();
}

class BMWBuilder implements Builder{
    private String wheel;
    private String oilBox;
    private String body;

    @Override
    public void buildWheel() {
        this.wheel="BMW Wheel";
    }

    @Override
    public void buildOilBox() {
        this.oilBox="BMW OilBox";
    }

    @Override
    public void buildBody() {
        this.body="BMW Body";
    }

    @Override
    public Car buildCar() {
        Car car=new Car();
        car.setBody(body);
        car.setWheel(wheel);
        car.setOilBox(oilBox);
        return car;
    }
}

class BenZBuilder implements Builder{
    private String wheel;
    private String oilBox;
    private String body;

    @Override
    public void buildWheel() {
        this.wheel="BenZ Wheel";
    }

    @Override
    public void buildOilBox() {
        this.oilBox="BenZ OilBox";
    }

    @Override
    public void buildBody() {
        this.body="BenZ Body";
    }

    @Override
    public Car buildCar() {
        Car car=new Car();
        car.setBody(body);
        car.setWheel(wheel);
        car.setOilBox(oilBox);
        return car;
    }
}

//指导组类
class Director{
    private Builder builder;//聚合Builder
    public Director(Builder builder){
        this.builder=builder;
    }
    public void setBuilder(Builder builder){
        this.builder=builder;
    }
    public Car construct(){
        builder.buildBody();
        builder.buildOilBox();
        builder.buildWheel();
        return builder.buildCar();
    }
}


