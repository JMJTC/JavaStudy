package designpattern.startuml.exp.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-13
 * @Description: 测试类
 * @Version: 1.0
 */
public class TestAppConfig implements Runnable{

    public static void main(String[] args) {
        //创建多个线程测试单例模式
        Thread thread1=new Thread(new TestAppConfig());
        Thread thread2=new Thread(new TestAppConfig());
        Thread thread3=new Thread(new TestAppConfig());

        thread1.start();
        thread2.start();
        thread3.start();
    }

    @Override
    public void run() {
        AppConfig appConfig=AppConfig.getInstance();
        System.out.println(appConfig);
    }
}
