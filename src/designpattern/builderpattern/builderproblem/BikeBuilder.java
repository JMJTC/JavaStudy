package designpattern.builderpattern.builderproblem;

/**
 * @author jmjtc
 */
public interface BikeBuilder {
    void buildTires();
    void buildFrame();
    Bike getBike();
}
