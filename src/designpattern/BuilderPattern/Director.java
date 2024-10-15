package designpattern.BuilderPattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 指导者类
 * @Version: 1.0
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }
    // 调用方法构建产品
    public void construct() {
        builder.buildPart1("Part1");
        builder.buildPart2("Part2");
    }
}
