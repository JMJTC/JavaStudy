package designpattern.BuilderPattern.BuilderProblem;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 山地车
 * @Version: 1.0
 */
public class MountainBikeBuilder implements BikeBuilder{
    private Bike bike;
    public MountainBikeBuilder(){
        bike = new Bike();
    }

    @Override
    public void buildTires() {
        bike.setTire("Knobby Tires");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("Aluminum Frame");
    }

    @Override
    public Bike getBike() {
        return bike;
    }
}
