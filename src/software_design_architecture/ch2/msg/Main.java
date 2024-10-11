package software_design_architecture.ch2.msg;

public class Main {
    public static void main(String[] args) {
        Email email=new Email();
        Person person=new Person(email);
        person.receiveMsg();
        person=new Person(new WeiXin());
        person.receiveMsg();
    }
}
