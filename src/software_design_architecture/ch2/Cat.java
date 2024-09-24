package software_design_architecture.ch2;

/**
 * @author jmjtc
 */

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public Cat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String shout() {
        return "喵";
    }
}
