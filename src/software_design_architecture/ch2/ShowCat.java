package software_design_architecture.ch2;

import javax.swing.*;


/**
 * @author jmjtc
 */
public class ShowCat {
    public static void main(String[] args) {
        ShowCat showCat = new ShowCat();
        showCat.buttonClick0();
        showCat.buttonClick0();
    }


    public void buttonClick0() {
        int isShout = JOptionPane.showConfirmDialog(null, "Do you want to shout?", "Shout", JOptionPane.YES_NO_OPTION);
        int times = 0;
        //用户输入叫声次数
        if (isShout == JOptionPane.YES_OPTION) {
            //解决当用户未输入数字时导致的报错
            while (true) {
                try {
                    times = Integer.parseInt(JOptionPane.showInputDialog("How many times do you want to shout?"));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            Cat cat=new Cat();
            cat.setName(JOptionPane.showInputDialog("What is the cat's name?"));
            StringBuilder words = new StringBuilder(cat.shout());
            for (int i = 1; i < times; i++) {
                words.append(" ").append(cat.shout());
            }
            JOptionPane.showMessageDialog(null, "My name is "+cat.getName()+" : "+words.toString(), cat.getName(), JOptionPane.INFORMATION_MESSAGE);
        }
    }


}
