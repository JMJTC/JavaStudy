package software_design_architecture.ch3.abstractfactorypattern;

/**
 * @author jmjtc
 */
public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
