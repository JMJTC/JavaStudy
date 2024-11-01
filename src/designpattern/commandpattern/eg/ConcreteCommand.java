package designpattern.commandpattern.eg;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-01
 * @Description: 实现命令接口，实现具体的操作
 * @Version: 1.0
 */
public class ConcreteCommand implements Command{
    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        //调用接受者相应操作
        receiver.action();
    }
}
