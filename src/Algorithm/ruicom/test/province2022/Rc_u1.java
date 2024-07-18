package Algorithm.ruicom.test.province2022;

import java.util.Scanner;

public class Rc_u1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int sum=sc.nextInt();
        int max=sc.nextInt();
        int[] data=new int[sum];
        for(int i=0;i<data.length;i++){
            data[i]=sc.nextInt();
        }
        int ans=0;
        int total=0;
        for(int i=0;i<data.length;i++){
            if(total+data[i]>max){
                //消费清零
                ans++;
                total=0;
                total=data[i];
            }else{
                total+=data[i];
            }
        }
        System.out.println(ans);
    }
}
