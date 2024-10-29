package designpattern.decoratorpattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-29
 * @Description: 具体组件
 * @Version: 1.0
 */
public class ConcreteComponent implements Component{
    @Override
    public void operation(){
        System.out.println("ConcreteComponent");
    }
}
