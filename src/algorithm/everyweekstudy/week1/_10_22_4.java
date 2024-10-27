package algorithm.everyweekstudy.week1;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_22_4 {
    public static int getLoopLength(int i){
        Map<Integer,Integer> map=new HashMap<>();//map泛型Map，主键用于存放余数，值为循环的次数
        int remainder=1;//第一个余数为1
        for(int cycleNumber=0;;cycleNumber++){
            if(map.containsKey(remainder)){
                return cycleNumber-map.get(remainder);//注意是差值，通过主键找到values
            }
            else{
                map.put(remainder,cycleNumber);
                remainder=remainder*10%i;//求下次被除数
                if(remainder==0)
                    return 0;
            }
        }
    }


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int ansNum=1,ansLoopLength=0;
        for(int i=1;i<n;i++){
            int loopLength=getLoopLength(i);
            if(loopLength>ansLoopLength){
                ansLoopLength=loopLength;
                ansNum=i;
            }
        }
        System.out.println(ansNum);
    }
}
