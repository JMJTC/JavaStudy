package designpattern.builderpattern.builderproblem;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 公路车
 * @Version: 1.0
 */
public class HighwayBikeBuilder implements BikeBuilder{
    private Bike bike;
    public HighwayBikeBuilder(){
        bike = new Bike();
    }

    @Override
    public void buildTires() {
        bike.setTire("Slim Tries");
    }

    @Override
    public void buildFrame() {
        bike.setFrame("Carbon Frame");
    }

    @Override
    public Bike getBike() {
        return bike;
    }
}
