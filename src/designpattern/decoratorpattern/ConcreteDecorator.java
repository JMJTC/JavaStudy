package designpattern.decoratorpattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-29
 * @Description: 具体的装饰者实现
 * @Version: 1.0
 */
public class ConcreteDecorator extends Decorator{
    public ConcreteDecorator(Component component){
        super(component);
    }

    //根据需要添加额外的方法
    @Override
    public void operation(){
        // 可以在调用前后添加额外的行为
        System.out.println("Before operation in ConcreteDecorator");
        super.operation();
        System.out.println("After operation in ConcreteDecorator");
    }
}
