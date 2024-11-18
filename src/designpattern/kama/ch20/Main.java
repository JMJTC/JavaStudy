package designpattern.kama.ch20;

import java.util.Scanner;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-18
 * @Description: 状态模式
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Light light=new Light();
        for(int i=0;i<n;i++){
            String str=sc.next();
            switch (str){
                case "ON":
                    light.on();
                    break;
                case "OFF":
                    light.off();;
                    break;
                case "BLINK":
                    light.blink();
                    break;
            }
        }
    }
}

abstract class State {
    protected Light light;
    public abstract void on();

    public abstract void off();

    public abstract void blink();
}

class OffState extends State {

    public OffState(Light light) {
        this.light=light;
    }
    public OffState(State state) {
        this.light=state.light;
    }

    @Override
    public void on() {
        System.out.println("ON");
        light.setState(new OnState(this));
    }

    @Override
    public void off() {
        System.out.println("OFF");
        light.setState(new OffState(this));
    }

    @Override
    public void blink() {
        System.out.println("Blinking");
        light.setState(new BlinkState(this));
    }
}

class OnState extends State {
    public OnState(Light light) {
        this.light=light;
    }
    public OnState(State state) {
        this.light=state.light;
    }


    @Override
    public void on() {
        System.out.println("ON");
        light.setState(new OnState(this));
    }

    @Override
    public void off() {
        System.out.println("OFF");
        light.setState(new OffState(this));
    }

    @Override
    public void blink() {
        System.out.println("Blinking");
        light.setState(new BlinkState(this));
    }
}

class BlinkState extends State {
    public BlinkState(Light light) {
        this.light=light;
    }
    public BlinkState(State state) {
        this.light=state.light;
    }

    @Override
    public void on() {
        System.out.println("ON");
        light.setState(new OnState(this));
    }

    @Override
    public void off() {
        System.out.println("OFF");
        light.setState(new OffState(this));
    }

    @Override
    public void blink() {
        System.out.println("Blinking");
        light.setState(new BlinkState(this));
    }
}

class Light {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Light(State state) {
        this.state = state;
    }

    public Light() {
        state = new OffState(this);
    }
    public void on(){
        System.out.print("Light is ");
        state.on();
    }
    public void off(){
        System.out.print("Light is ");
        state.off();
    }

    public void blink(){
        System.out.print("Light is ");
        state.blink();
    }
}