package designpattern.prototypepattern.eg2;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-08
 * @Description: 原型模式深克隆
 * @Version: 1.0
 */

public class DeepClone {
    public static void main(String[] args) {
        //测试
        Test1.main(args);
    }
}

//测试1
class Test1{
    public static void main(String[] args) {

        //测试
        Mail2 mail = new Mail2();
        mail.setContent("邮件内容");
        mail.setName("张三");
        mail.setAddress("1234567890");
        mail.setAttachment(new Attachment("附件.txt"));
        Mail2 mail1 = (Mail2) mail.clone();
        System.out.println(mail1);
        System.out.println("邮件是否相同:"+ (mail == mail1));
        System.out.println("附件是否相同:"+ (mail.getAttachment() == mail1.getAttachment()));
    }
}


//抽象原型类
abstract class Prototype implements Cloneable{
    public abstract Prototype clone();

    // 公共的 clone 方法
    public Prototype clonePrototype() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

//具体原型类 邮件类型
class Mail extends Prototype{
    private String name;
    private String address;
    private String content;
    private Attachment attachment;

    @Override
    public Prototype clone() {
        return clonePrototype();
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", attachment=" + attachment.getName() +
                '}';
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Mail(String name, String address, String content, Attachment attachment) {
        this.name = name;
        this.address = address;
        this.content = content;
        this.attachment = attachment;
    }
    public Mail(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}

//具体原型类 邮件类型
class Mail2 extends Prototype{
    private String name;
    private String address;
    private String content;
    private Attachment attachment;

    @Override
    public Prototype clone() {
        Mail2 mail=(Mail2)clonePrototype();
        mail.attachment=attachment.clone();
        return mail;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", attachment=" + attachment.getName() +
                '}';
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Mail2(String name, String address, String content, Attachment attachment) {
        this.name = name;
        this.address = address;
        this.content = content;
        this.attachment = attachment;
    }
    public Mail2(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}



//邮件的附件
class Attachment implements Cloneable{
    private String name;
    public void download(){
        System.out.println("下载附件:"+name);
    }

    public Attachment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Attachment clone(){
        try{
            return (Attachment) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }
}


