package algorithm.pat;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class L1_004 {
    //C=5×(F−32)/9
    public static void main(String[] args) {
        //取整
        Scanner sc=new Scanner(System.in);
        int f= sc.nextInt();
        System.out.print("Celsius = "+5*(f-32)/9);
    }
}
