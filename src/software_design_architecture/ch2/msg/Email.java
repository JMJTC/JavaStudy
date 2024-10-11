package software_design_architecture.ch2.msg;

public class Email implements IReceiveMsg{
    @Override
    public void receiveMsg() {
        System.out.println("Email receive msg");
    }
}
