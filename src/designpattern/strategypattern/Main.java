package designpattern.strategypattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-29
 * @Description: 策略模式
 * @Version: 1.0
 */
// 1. 抽象策略抽象类
abstract class Strategy {
    // 抽象方法
    public abstract void algorithmInterface();
}

// 2. 具体策略类1
class ConcreteStrategyA extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("Strategy A");
        // 具体的策略1执行逻辑
    }
}

// 3. 具体策略类2
class ConcreteStrategyB extends Strategy {
    @Override
    public void algorithmInterface() {
        System.out.println("Strategy B");
        // 具体的策略2执行逻辑
    }
}

// 4. 上下文类
class Context {
    private Strategy strategy;

    // 设置具体的策略
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    // 执行策略
    public void contextInterface() {
        strategy.algorithmInterface();
    }
}

// 5. 客户端代码
public class Main{
    public static void main(String[] args) {
        // 创建上下文对象，并设置具体的策略
        Context contextA = new Context(new ConcreteStrategyA());
        // 执行策略
        contextA.contextInterface();

        Context contextB = new Context(new ConcreteStrategyB());
        contextB.contextInterface();
    }
}
