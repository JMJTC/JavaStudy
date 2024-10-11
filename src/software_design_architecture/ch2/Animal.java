package software_design_architecture.ch2;

/**
 * @author jmjtc
 */
//一个对象的声明类型可能与其实际类型不符
//eg: 一个Animal对象可能实际是Dog对象
//Java的实例方法调用是基于运行时的实际类型的动态调用，而非变量的声明类型。
public abstract class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public abstract String shout();
}
