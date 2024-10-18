package algorithm.ContestLan.guo13;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class B {
    public static void main(String[] args) {
        int count=0,min=2333333,max=23333333;
        int[] data=new int [max+1];
        List<Integer> prime=new ArrayList<>();
        for(int i=2;i<=max;i++){
            if(data[i]==0){
                data[i]=1;
                prime.add(i);
            }
            if(i>=min&&data[i]==12){
                count++;
            }
            for(int n:prime){
                if(i*n>max){
                    break;
                }
                data[i*n]=data[i]+1;
                if(i%n==0){
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
