package designpattern.BuilderPattern.BuilderProblem;

/**
 * @author jmjtc
 */
public interface BikeBuilder {
    void buildTires();
    void buildFrame();
    Bike getBike();
}
