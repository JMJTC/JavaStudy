package designpattern.startuml.exp.ch01;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-06
 * @Description:
 * @Version: 1.0
 */
public class AppConfig {
    // 持有唯一的实例
    private static AppConfig instance;

    // 配置文件中的参数
    private String parameter;

    // 私有构造函数，防止外部实例化
    private AppConfig() {
        // 可以在这里加载配置文件，并初始化 parameter
        // 例如：this.parameter = readConfigFile();
        System.out.println("AppConfig instance created");
    }

    // 提供全局访问点
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    // 获取配置文件中的参数
    public String getParameter() {
        return parameter;
    }

    // 设置配置文件中的参数
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    // 示例方法，用于展示如何使用该类
    public void displayParameter() {
        System.out.println("Parameter: " + this.parameter);
    }

    // 主方法用于测试
    public static void main(String[] args) {
        AppConfig config = AppConfig.getInstance();
        config.setParameter("TestValue");
        config.displayParameter();

        // 尝试获取另一个实例，并检查参数值
        AppConfig anotherConfig = AppConfig.getInstance();
        anotherConfig.displayParameter();
    }
}
