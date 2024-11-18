package algorithm.tools;

import java.sql.SQLSyntaxErrorException;

/**
 * @author jmjtc
 */
public class Main {
    public static void main(String[] args) {
        Cat cat=new Cat("cat123");
        Cat cat1=cat;
        cat1.setName("123");
        System.out.println(cat.getName());

    }
}

class Cat{
    String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}