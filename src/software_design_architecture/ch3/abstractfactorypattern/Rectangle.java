package software_design_architecture.ch3.abstractfactorypattern;

/**
 * @author jmjtc
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
