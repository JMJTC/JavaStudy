package designpattern.startuml.exp.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-06
 * @Description:
 * @Version: 1.0
 */

//懒汉模式+双重锁检查
public class AppConfig {
    // 持有唯一的实例
    private static volatile AppConfig instance;

    // 配置文件中的参数
    private String parameterA;

    // 私有构造函数，防止外部实例化
    private AppConfig() {
        System.out.println("AppConfig instance created");
    }

    // 提供全局访问点
    public static  AppConfig getInstance() {
        if (instance == null) {
            synchronized (AppConfig.class){
                if(instance==null){
                    instance = new AppConfig();
                }
            }
        }
        return instance;
    }

    // 获取配置文件中的参数
    public String getParameter() {
        return parameterA;
    }

    // 设置配置文件中的参数
    public void setParameter(String parameter) {
        this.parameterA = parameter;
    }
}


