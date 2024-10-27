package algorithm.everyweekstudy.WinterContest1;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest03 {
    public static int maxOfSum(int[][] data){
        //自下而上
        for(int i=data.length-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                data[i][j]+=Math.max(data[i+1][j],data[i+1][j+1]);
            }
        }
        return data[0][0];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        int[][] data=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                data[i][j]= sc.nextInt();
            }
        }
        System.out.println(maxOfSum(data));
    }
}
