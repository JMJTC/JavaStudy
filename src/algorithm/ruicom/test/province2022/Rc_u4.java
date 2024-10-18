package algorithm.ruicom.test.province2022;

import java.util.Scanner;

public class Rc_u4 {
    private static int[] member=new int[6];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        input(sc);
    }

    public static void input(Scanner sc){
        for(int i=0;i<6;i++){
            member[i]=sc.nextInt();
        }
    }
}
