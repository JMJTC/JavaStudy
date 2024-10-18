package algorithm.tools;

import java.util.Scanner;

public class GetScore {
    public static void main(String[] args) {
        int num=0;//课程数
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入课程数：");
        num=sc.nextInt();
        double[][] score=new double[num][2];//0 学分 1绩点
        for(int i=0;i<num;i++){
            System.out.println("请输入第"+(i+1)+"门课程的学分和绩点：");
            score[i][0]=sc.nextDouble();
            score[i][1]=sc.nextDouble();
        }
        double sum=0.0;
        for(int i=0;i<num;i++){
            sum+=score[i][0]*score[i][1];
        }
        //计算学分总和
        double total=0.0;
        for(int i=0;i<num;i++){
            total+=score[i][0];
        }
        //计算平均绩点
        double avg=sum/total;
        System.out.println("总学分："+total);
        System.out.println("平均绩点："+avg);
    }
}
