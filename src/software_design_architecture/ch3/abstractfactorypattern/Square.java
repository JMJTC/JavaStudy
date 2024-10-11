package software_design_architecture.ch3.abstractfactorypattern;

/**
 * @author jmjtc
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
