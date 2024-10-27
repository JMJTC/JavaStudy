package designpattern.builderpattern;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-15
 * @Description: 具体建造者类
 * @Version: 1.0
 */
public class ConcreteBuilder implements Builder{
    private Product product = new Product();

    @Override
    public void buildPart1(String part1) {
        product.setPart1(part1);
    }

    @Override
    public void buildPart2(String part2) {
        product.setPart2(part2);
    }

    @Override
    public Product getResult() {
        return product;
    }
}
