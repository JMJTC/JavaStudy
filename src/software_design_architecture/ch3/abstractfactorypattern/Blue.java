package software_design_architecture.ch3.abstractfactorypattern;

/**
 * @author jmjtc
 */
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
