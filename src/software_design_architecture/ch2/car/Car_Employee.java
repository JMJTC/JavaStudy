package software_design_architecture.ch2.car;


/**
 * @author jmjtc
 */

//组合&&聚合
//聚合：整体和部分的关系，部分可以脱离整体存在，
//组合：整体和部分的关系，部分不可以脱离整体存在
//生命周期：
//聚合：部分的生命周期可以独立于整体的生命周期
//组合：部分的生命周期不可以独立于整体的生命周期
public class Car_Employee {
    public static void main(String[] args) {
        Car car=new Car(new Engine());
    }
}
