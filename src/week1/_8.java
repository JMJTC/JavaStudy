package week1;

import java.util.Scanner;

class data{
    public long number;
    public long count;
    public data(long number,long count){
        this.number=number;
        this.count=count;
    }
}

public class _8 {
    public static void main(String[] args){
        int n;
        Scanner in=new Scanner(System.in);
        n= in.nextInt();
        data []data=new data[n];
        //在声明对象数组后 ，必须对每个数组成员进行实例化话 才能直接使用，否则报空指针异常！
        //初始化
        for(int i=0;i<data.length;i++){
            data[i]=new data(i+1,1);
        }
        for(int i=0;i<data.length;i++){
//            if(i==113382)
//                System.out.println("wa");
            while(data[i].number!=1){
                if(data[i].number%2==0){
                    data[i].number/=2;
                    if(data[i].number<=i&&data[i].number!=1){
                        data[i].count+=data[(int) (data[i].number-1)].count;
                        break;
                    }
                    data[i].count++;
                }
                else{
                    data[i].count++;
                    data[i].number=data[i].number*3+1;
                }
            }
        }
        int MaxNumber=0;
        long MaxCount=0;
        for(int i=0;i<data.length;i++){
            if(data[i].count>MaxCount){
                MaxNumber=i+1;
                MaxCount=data[i].count;
            }
        }
        System.out.printf("%d %d",MaxNumber,MaxCount);
    }
}
