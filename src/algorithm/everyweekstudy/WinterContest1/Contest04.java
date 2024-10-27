package algorithm.everyweekstudy.WinterContest1;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest04 {
    public static boolean isWin(int n){
        return n % 4 != 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            if(isWin(sc.nextInt())){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
