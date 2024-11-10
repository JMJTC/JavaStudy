package designpattern.StatePattern.eg1;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-08
 * @Description: 状态模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {

    }
}

interface State{
    void handle(Context context);
}

class Context{
    private State state;

    public void setState(State state){
        this.state = state;
    }

    public void request(){//供客户端请求的方法
        state.handle(this);
    }
}
