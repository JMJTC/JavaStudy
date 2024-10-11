package software_design_architecture.ch3.abstractfactorypattern;

/**
 * @author jmjtc
 */
public class Green implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}