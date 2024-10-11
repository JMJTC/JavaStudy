package software_design_architecture.ch2.msg;

public class WeiXin implements IReceiveMsg{

    @Override
    public void receiveMsg() {
        System.out.println("receive msg from weixin");
    }
}
