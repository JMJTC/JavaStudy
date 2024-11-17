package designpattern.startuml.exp.ch11;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-17
 * @Description: 状态模式
 * @Version: 1.0
 */
public class Client {
    public static void main(String[] args) {
        Account account=new Account(0.0,"小明");
        account.deposit(1000);
        account.withdraw(2000);
        account.withdraw(100);
        account.withdraw(100);
    }
}

abstract class State{
    protected Account acc;
    public abstract void deposit(double money);
    public abstract void withdraw(double money);
    public State(Account acc){
        this.acc=acc;
    }
    public void stateCheck() {
        double balance=acc.getBalance();
        if(balance<0&&balance>=-1000){
            acc.setState(new YellowState(acc));
        }else if(balance<-1000){
            acc.setState(new RedState(acc));
        }else{
            acc.setState(new GreenState(acc));
        }

    }

}

class GreenState extends State{
    public GreenState(Account acc){
        super(acc);
    }

    @Override
    public void deposit(double money) {
        acc.setBalance(acc.getBalance()+money);
        System.out.println("已存款："+money+"   "+'\n'+"账户余额："+acc.getBalance());
        stateCheck();
    }

    @Override
    public void withdraw(double money) {
        acc.setBalance(acc.getBalance()-money);
        System.out.println("已取款："+money+"   "+'\n'+"账户余额："+acc.getBalance());
        stateCheck();
    }

}

class YellowState extends State{
    public YellowState(Account acc){
        super(acc);
    }

    @Override
    public void deposit(double money) {
        acc.setBalance(acc.getBalance()+money);
        System.out.println("已存款："+money+"   "+'\n'+"账户余额："+acc.getBalance());
        stateCheck();
    }

    @Override
    public void withdraw(double money) {
        acc.setBalance(acc.getBalance()-money);
        System.out.println("已取款："+money+"   "+'\n'+"账户余额："+acc.getBalance());
        stateCheck();
    }

}

class RedState extends State{
    public RedState(Account acc){
        super(acc);
    }

    @Override
    public void deposit(double money) {
        acc.setBalance(acc.getBalance()+money);
        System.out.println("已存款："+money+"   "+'\n'+"账户余额："+acc.getBalance());
        stateCheck();
    }

    @Override
    public void withdraw(double money) {
        System.out.println("账户已透支，无法取款");
        stateCheck();
    }

}

class Account{
    private double balance;
    private State state;
    private String name;

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
        state=new GreenState(this);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void deposit(double money){
        state.deposit(money);
        System.out.println("账户状态："+state.getClass().getName());
        System.out.println("=================================");
    }
    public void withdraw(double money){
        state.withdraw(money);
        System.out.println("账户状态："+state.getClass().getName());
        System.out.println("=================================");
    }
}