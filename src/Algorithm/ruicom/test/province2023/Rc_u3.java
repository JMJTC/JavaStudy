package Algorithm.ruicom.test.province2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Rc_u3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        input(sc);
    }

    public static void input(Scanner sc){
        int t=sc.nextInt();//数据量
        for(int i=0;i<t;i++){
            int[] data=new int[5];
            for(int j=0;j<5;j++){
                data[j]= sc.nextInt();
            }
            solve(data);
        }
    }

    public static void solve(int[] data){
        //判断数据类型
        int[] map=new int[7];
        for(int i=0;i<5;i++){
            map[data[i]]++;
        }
        //5个同点数
        for(int i=1;i<=6;i++){
            if(map[i]==5){
                System.out.println("0 0 1");
                return;
            }
        }
        //4个同点数
        for(int i=1;i<=6;i++){
            if(map[i]==4){
                System.out.println("1 1 6");
                return;
            }
        }
        //葫芦
        boolean flag2=false,flag3=false;
        for(int i=1;i<=6;i++){
            if(map[i]==2){
                flag2=true;
                continue;
            }
            if(map[i]==3){
                flag3=true;
            }
        }
        if(flag2&&flag3){
            System.out.println("2 11 36");
            return;
        }

        //6高顺子
        boolean flag=true;
        for(int i=2;i<=6;i++){
            if(map[i]!=1){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("3 1 27");
            return;
        }

        //5高顺子
        flag=true;
        for(int i=1;i<=5;i++){
            if(map[i]!=1){
                flag=false;
                break;
            }
        }
        if(flag){
            System.out.println("3 7 108");
        }

        //三个同点数
        for(int i=1;i<=6;i++){
            if(map[i]==3){
                System.out.println("2 4 9");
                return;
            }
        }

        //两对
        int count=0;
        for(int i=1;i<=6;i++){
            if(map[i]==2){
                count++;
            }
        }
        if(count==2){
            System.out.println("3 4 9");
            return;
        }


        //一对
        for(int i=1;i<=6;i++){
            if(map[i]==2){
                System.out.println("3 13 18");
                return;
            }
        }

        //其他情况
        System.out.print("1 5 6");
    }
}
