package designpattern.compositepattern.classeg;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-22
 * @Description: 课_组合模式例子
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Composite university=new Composite("清华大学");
        Composite computerCollege,infoEngineerCollege;
        computerCollege=new Composite("计算机学院");
        university.add(computerCollege);
        infoEngineerCollege=new Composite("信息工程学院");
        university.add(infoEngineerCollege);

        Composite ruan=new Composite("软件工程系");
        computerCollege.add(ruan);
        computerCollege.add(new Leaf("网络工程系"));
        computerCollege.add(new Leaf("计算机科学与技术系"));
        //TODO 能否再多一个层级结构
        ruan.add(new Leaf("test1"));
        ruan.add(new Leaf("test2"));


        infoEngineerCollege.add(new Leaf("通信工程系"));
        infoEngineerCollege.add(new Leaf("电子工程系"));
        university.operation();
    }
}

//抽象构件
abstract class Component{
    protected String name;

    public Component(String name){
        this.name=name;
    }

    //业务方法
    protected  abstract void operation();
}

//叶子 构件
class Leaf extends Component{
    public Leaf(String name){
        super(name);
    }

    @Override
    protected void operation(){
        System.out.println(name);
    }
}

//容器构件
class Composite extends Component{
    private List<Component> components=new ArrayList<>();

    public Composite(String name){
        super(name);
    }
    public void add(Component c){
        components.add(c);
    }
    protected void remove(Component c){
        components.remove(c);
    }
    protected List<Component> getChild(){
        return components;
    }

    @Override
    protected void operation(){
        System.out.println(name);
        for(Component c:components){
            c.operation();
        }
    }
}
