package Algorithm.ruicom.test.province2023;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Rc_u1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();//n条获奖记录
        int[][] data=new int[2][3];
        for(int i=0;i<n;i++){
            int a=sc.nextInt();//国家
            int b=sc.nextInt();//奖项
            data[a][b-1]++;
        }
        for(int i=0;i<2;i++){
            for(int j=0;j<3;j++){
                System.out.print(data[i][j]);
                if(j!=2){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //who win?
        if(data[0][0]>data[1][0]){
            System.out.print("The first win!");
        }else if(data[0][0]<data[1][0]){
            System.out.print("The second win!");
        }else{
            if(data[0][1]>data[1][1]){
                System.out.print("The first win!");
            }else if(data[0][1]<data[1][1]){
                System.out.print("The second win!");
            }else{
                if(data[0][2]>data[1][2]){
                    System.out.print("The first win!");
                }else if(data[0][2]<data[1][2]){

                    System.out.print("The second win!");
                }
            }
        }
    }
}
