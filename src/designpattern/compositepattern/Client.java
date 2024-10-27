package designpattern.compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-22
 * @Description: 组合模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        //创建叶子节点
        Leaf leaf=new Leaf();
        //创建组合节点，并添加叶子节点
        Composite composite=new Composite();
        composite.add(leaf);

        composite.operation();
    }
}

//组件接口
interface Component {
    void operation();
}

//叶子节点
class Leaf implements Component{
    @Override
    public void operation(){
        System.out.println("Leaf Operation.");
    }
}

//组合节点，包含叶子节点的操作行为 增删改查等操作
class Composite implements Component{
    private List<Component> components=new ArrayList<>();

    public void add(Component component){
        components.add(component);
    }

    public void remove(Component component){
        components.remove(component);
    }
    @Override
    public void operation(){
        System.out.println("Composite Operation!");
        for(Component item:components){
            item.operation();
        }
    }
}
