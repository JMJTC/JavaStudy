package designpattern.factorypattern;

import java.util.Scanner;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-29
 * @Description: 积木工厂
 * @Version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        Factory factory;
        Block block;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String str=sc.next();
            int count=sc.nextInt();
            if("Square".equals(str)){
                for(int j=0;j<count;j++){
                    factory=new SquareBlockFactory();
                    block=factory.operation();
                    block.draw();
                }
            }else{
                for(int j=0;j<count;j++){
                    factory=new CircleBlockFactory();
                    block=factory.operation();
                    block.draw();
                }
            }
        }
    }
}

interface Block{
    void draw();
}

class CircleBlock implements Block{
    @Override
    public void draw(){
        System.out.println("Circle Block");
    }
}

class SquareBlock implements Block{
    @Override
    public void draw(){
        System.out.println("Square Block");
    }
}

interface Factory{
    Block operation();
}

class CircleBlockFactory implements Factory{
    @Override
    public Block operation(){
        return new CircleBlock();
    }
}

class SquareBlockFactory implements Factory{
    @Override
    public Block operation(){
        return new SquareBlock();
    }
}


