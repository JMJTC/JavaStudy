package designpattern.commandpattern.eg;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-01
 * @Description: 定义接受者类，知道如何实施与执行一个请求相关的操作
 * @Version: 1.0
 */
public class Receiver {
    public void action(){
        //执行操作
        System.out.println("执行操作");
    }
}
