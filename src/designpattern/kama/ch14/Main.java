package designpattern.kama.ch14;

import java.util.Scanner;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-18
 * @Description: 策略模式
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Context context=new Context();
        Strategy strategy1=new StrategyA();
        Strategy strategy2=new StrategyB();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int price=sc.nextInt();
            int s= sc.nextInt();
            if(s==1){
                context.setStrategy(strategy1);
            }else{
                context.setStrategy(strategy2);
            }
            price=context.contextInterface(price);
            System.out.println(price);
        }
    }
}

interface Strategy{
    int discount(int price);
}

class StrategyA implements Strategy{

    @Override
    public int discount(int price) {
        return price * 9 / 10;
    }
}

class StrategyB implements Strategy{

    @Override
    public int discount(int price) {
        if(price>=100&&price<150){
            return price-10;
        }else if(price>=150&&price<200){
            return price-15;
        }else if(price>=200&&price<300){
            return price-25;
        }else{
            return price-40;
        }
    }
}

class Context{
    Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public Context() {
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
    public int contextInterface(int price){
        return strategy.discount(price);
    }
}