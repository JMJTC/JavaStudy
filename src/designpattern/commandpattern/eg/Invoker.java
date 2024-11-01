package designpattern.commandpattern.eg;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-01
 * @Description: 定义调用者类，调用命令对象执行请求。
 * @Version: 1.0
 */
public class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }
    public void executeCommand(){
        command.execute();
    }
}
