package software_design_architecture.ch2.car;

public class Engine {
    String attr1;
    String attr2;

    public void operation1() {
        System.out.println("Engine operation1");
    }

    public void operation2() {
        System.out.println("Engine operation2");
    }

    public Engine() {
    }

    public Engine(String attr1, String attr2) {
        this.attr1 = attr1;
        this.attr2 = attr2;
    }


    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }
}
