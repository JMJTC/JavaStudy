package software_design_architecture.ch3.abstractfactorypattern;

/**
 * @author jmjtc
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
