package Algorithm.EveryWeekStudy.WinterContest1;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            //输入
            int tomato,cheese;
            tomato=sc.nextInt();
            cheese=sc.nextInt();
            int big,small;
            small=(4*cheese-tomato)/2;
            big=cheese-small;
            if((small*2+big*4==tomato)&&(small+big==cheese)&&small>=0&&big>=0){
                System.out.println(big+" "+small);
            }else{
                System.out.println("WustJavaClub");
            }
        }
    }
}
