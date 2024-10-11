package software_design_architecture.ch3.abstractfactorypattern;

/**
 * @author jmjtc
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
