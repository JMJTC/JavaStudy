package algorithm.ContestLan._14th;


import java.util.Scanner;

/**
 * @author jmjtc
 */
public class D_TotalRectangularArea {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x1=sc.nextInt(),y1=sc.nextInt(), x2=sc.nextInt(),y2= sc.nextInt(), x3=sc.nextInt(),y3=sc.nextInt(),x4=sc.nextInt(),y4=sc.nextInt();
        long a1=x2-x1,b1=y2-y1;//长宽
        long a2=x4-x3,b2=y4-y3;
        //1.没有重叠部分
        if(x2 < x3 || x4 < x1||y2<y3||y1>y4){
            System.out.println(a1*b1+a2*b2);
        }else{//2.有重叠部分
            long zuoX=Math.max(x1,x3);
            long zuoY=Math.max(y1,y3);
            long youX=Math.min(x2,x4);
            long youY=Math.min(y2,y4);
            System.out.println(a1*b1+a2*b2-(youX-zuoX)*(youY-zuoY));
        }
    }
}
