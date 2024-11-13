package designpattern.singlepattern;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-13
 * @Description: 小明的购物车
 * @Version: 1.0
 */
public class SingletonProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name;
        int num;
        while (sc.hasNext()) {
            name = sc.next();
            num = sc.nextInt();
            Cart2.getCart().add(name, num);
        }
        Cart2.getCart().show();
    }
}


//饿汉模式
class Cart {
    private final Map<String, Integer> cart;

    private static final Cart INSTENCE = new Cart();

    private Cart() {
        cart = new LinkedHashMap<>();
    }

    public static Cart getCart() {
        return INSTENCE;
    }

    public void add(String name, int num) {
        cart.put(name, cart.getOrDefault(name, 0) + num);
    }

    public void show() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

//懒汉模式
class Cart2 {
    private Map<String, Integer> cart;
    //volatile 是 Java 中用于修饰变量的关键字，它可以确保变量的可见性，即一个线程对变量的修改对其他线程是可见的。
    // volatile 关键字可以防止指令重排序，确保多线程环境下的数据一致性。
    private static volatile Cart2 INSTENCE;

    private Cart2() {
        cart = new LinkedHashMap<>();
    }

    public static Cart2 getCart() {
        if (INSTENCE == null) {
            synchronized (Cart2.class) {
                if (INSTENCE == null) {
                    INSTENCE = new Cart2();
                }
            }
        }
        return INSTENCE;
    }
    public void add(String name, int num) {
        cart.put(name, cart.getOrDefault(name, 0) + num);
    }
    public void show() {
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
