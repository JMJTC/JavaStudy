package software_design_architecture.ch2;

/**
 * @author jmjtc
 */
//一个对象的声明类型可能与其实际类型不符
//eg: 一个Animal对象可能实际是Dog对象
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
