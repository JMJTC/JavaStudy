package designpattern.commandpattern.eg;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-01
 * @Description: 客户端
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Receiver receiver=new Receiver();
        Command command=new ConcreteCommand(receiver);
        Invoker invoker=new Invoker(command);

        invoker.executeCommand();
    }
}
