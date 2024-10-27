package designpattern.builderpattern.builderproblem;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 自行车类
 * @Version: 1.0
 */
public class Bike {
    private String frame;
    private String tire;
    @Override
    public String toString() {
        return frame+" "+tire;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getTire() {
        return tire;
    }

    public void setTire(String tire) {
        this.tire = tire;
    }
}
