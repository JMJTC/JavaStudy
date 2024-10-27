package designpattern.builderpattern.builderproblem;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 指导者
 * @Version: 1.0
 */
public class BikeDirector {
    private BikeBuilder builder;
    public BikeDirector(BikeBuilder builder){
        this.builder = builder;
    }
    public Bike construct(){
        builder.buildFrame();
        builder.buildTires();
        return builder.getBike();
    }
}
