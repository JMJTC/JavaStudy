package designpattern.decoratorpattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-29
 * @Description: 客户端使用
 * @Version: 1.0
 */
public class Client {


    public static void main(String[] args) {
        Component component=new ConcreteComponent();
        component.operation();
        component=new ConcreteDecorator(component);
        component.operation();
    }
}
