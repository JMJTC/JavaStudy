package algorithm.everyweekstudy.WinterContest1;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest05 {
    static int n,k,count=0;
    static int[] data;
    public static boolean isPrime(int sum){
        for(int i=2;i<=Math.sqrt(sum);i++){
            if(sum%i==0){
                return false;
            }
        }
        return true;
    }

    public static void getCountOfPrime(int sum,int i,int index){
        if(i!=k){
            for(int j=index;j<n;j++){
                getCountOfPrime(sum+data[j],i+1,j+1);
            }
        }else{
            if(isPrime(sum)){
                count++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        n= sc.nextInt();k= sc.nextInt();
        data=new int[n];
        for(int i=0;i<n;i++){
            data[i]=sc.nextInt();
        }
        getCountOfPrime(0,0,0);
        System.out.println(count);
    }
}
