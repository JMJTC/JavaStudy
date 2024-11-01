package designpattern.commandpattern.eg2;

import java.util.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-01
 * @Description: 客户端
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        TVReceiver tvReceiver=new TVReceiver();
        Command command=new TVOnCommand(tvReceiver);
        Invoker invoker=new Invoker();
        invoker.addCommand(command);
        invoker.executeCommandsInQueue();
    }
}

interface Command{
    public void execute();
}

class Invoker{
    private Queue<Command> commands;//命令队列

    public Invoker(){
        commands=new LinkedList<>();
    }

    //设置命令并执行
    public void setAndExecute(Command command){
        command.execute();
        commands.offer(command);
    }
    //添加命令
    public void addCommand(Command command){
        commands.offer(command);
    }
    // 执行命令队列中的所有命令
    public void executeCommandsInQueue() {
        for (Command command : commands) {
            command.execute();
        }
    }
}

class LightOnCommand implements Command{
    LightReceiver lightReceiver;//聚合接受者

    public LightOnCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.on();
    }
}
class LightOffCommand implements Command{
    LightReceiver lightReceiver;//聚合接受者

    public LightOffCommand(LightReceiver lightReceiver) {
        this.lightReceiver = lightReceiver;
    }

    @Override
    public void execute() {
        lightReceiver.off();
    }
}
class TVOnCommand implements Command{
    TVReceiver tvReceiver;//聚合接受者

    public TVOnCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        tvReceiver.on();
    }
}
class TVOffCommand implements Command{
    TVReceiver tvReceiver;//聚合接受者

    public TVOffCommand(TVReceiver tvReceiver) {
        this.tvReceiver = tvReceiver;
    }

    @Override
    public void execute() {
        tvReceiver.off();
    }
}

class LightReceiver{
    public void on(){
        System.out.println("light on");
    }
    public void off(){
        System.out.println("light off");
    }
}

class TVReceiver{
    public void on(){
        System.out.println("tv on");
    }
    public void off(){
        System.out.println("tv off");
    }
}
