package designpattern;


/**
 * @author jmjtc
 */
public class SingletonPattern {
    public static void main(String[] args) {

    }
}

//饿汉模式：实例在类加载时就被创建, 这种方式的实现相对简单，但是实例有可能没有使用而造成资源浪费。
class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    private Singleton1() {
        //私有构造方法，防止外部实例化
    }
    public static Singleton1 getInstance() {
        return instance;
    }
}

//懒汉模式：实例在第一次使用时才创建，这种方式的实现相对复杂，但是可以避免资源浪费。
class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {
        // 私有构造方法，防止外部实例化
    }
    // 使用了同步关键字来确保线程安全, 可能会影响性能
    //synchronized 是 Java 中用于实现线程同步的关键字，它可以用于方法或代码块，
    // 确保同一时间只有一个线程可以执行被 synchronized 修饰的代码。这有助于避免多线程环境下的数据不一致问题。
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

//在懒汉模式的基础上，可以使用双重检查锁来提高性能。
class Singleton3 {
    //volatile 是 Java 中用于修饰变量的关键字，它可以确保变量的可见性，即一个线程对变量的修改对其他线程是可见的。
    // volatile 关键字可以防止指令重排序，确保多线程环境下的数据一致性。
    private static volatile Singleton3 instance;

    private Singleton3() {
        // 私有构造方法，防止外部实例化
    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            synchronized (Singleton3.class) {
                if (instance == null) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
