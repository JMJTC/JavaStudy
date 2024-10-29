package designpattern.decoratorpattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-29
 * @Description: 定义一个抽象的装饰者类，继承自Component
 * @Version: 1.0
 */
public abstract class Decorator implements Component{
    protected Component component;

    public Decorator(Component component){
        this.component=component;
    }

    @Override
    public void operation(){
        component.operation();
    }
}
