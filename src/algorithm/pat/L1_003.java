package algorithm.pat;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class L1_003 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str= sc.nextLine();

        int[] data=new int[10];
        for(int i=0;i<str.length();i++){
            data[str.charAt(i)-'0']++;
        }

        //打印
        for(int i=0;i<10;i++){
            if(data[i]!=0){
                System.out.println(i+":"+data[i]);
            }
        }
    }
}
