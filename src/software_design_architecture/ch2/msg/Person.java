package software_design_architecture.ch2.msg;

public class Person {
    public IReceiveMsg msg;
    public void setMsg(IReceiveMsg msg) {
        this.msg = msg;
    }
    public void receiveMsg() {
        msg.receiveMsg();
    }

    public Person(IReceiveMsg msg) {
        this.msg = msg;
    }
}
