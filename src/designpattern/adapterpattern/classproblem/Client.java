package designpattern.adapterpattern.classproblem;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-18
 * @Description: 适配器问题
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Adapter adapter = new Adapter();
        adapter.setCat(new ConcreteCat());
        adapter.setDog(new ConcrectDog());
        System.out.println("猫学狗");
        adapter.catchMouse();
        System.out.println("===========");
        System.out.println("狗学猫");
        adapter.gnawBone();
    }
}


interface Cat{
    void catchMouse();
}

interface Dog{
    void gnawBone();
}

class ConcreteCat implements Cat{
    @Override
    public void catchMouse() {
        System.out.println("抓老鼠");
    }
}

class ConcrectDog implements Dog{
    @Override
    public void gnawBone() {
        System.out.println("啃骨头");
    }
}

class Adapter implements Dog,Cat{
    private Dog dog;
    private Cat cat;

    public void setCat(Cat cat) {
        this.cat = cat;
    }
    public void setDog(Dog dog) {
        this.dog = dog;
    }
    public void catchMouse(){
        dog.gnawBone();
    }
    public void gnawBone(){
        cat.catchMouse();
    }
}