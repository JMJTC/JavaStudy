package Algorithm.EveryWeekStudy.week1;

import java.util.Scanner;

public class _6 {
    public static void main(String[] args){
        //数据的输入
        short n,m,x;
        Scanner in=new Scanner(System.in);
        n=in.nextShort();
        m=in.nextShort();
        x=in.nextShort();
        short[][] data=new short[n][m];
        for(short i=0;i<data.length;i++){
            for(short j=0;j<data[i].length;j++){
                data[i][j]=in.nextShort();
            }
        }
        long max=0;
        //遍历左右方向的最大数
        //数据已保证count_row>0;
        short count_row= (short) (m-x+1);
        for(short i=0;i<n;i++){//一共n行
            for(short j=0;j<count_row;j++){
                long temp=1;
                for(short k=0;k<x;k++){
                    temp*=data[i][k+j];
                }

                if(temp>max)
                    max=temp;
            }
        }

        //遍历上下方向的最大数
        short count_col=(short)(n-x+1);
        for(short i=0;i<m;i++){//一共m列
            for(short j=0;j<count_col;j++){
                long temp=1;
                for(short k=0;k<x;k++){
                    temp*=data[k+j][i];
                }
                if(temp>max)
                    max=temp;
            }
        }

        //遍历斜线上的最大数
        //1.左对角线
        for(short i=0;i<count_col;i++){//纵向的次数
            for(short j=0;j<count_row;j++){//横向的次数
                long temp=1;
                for(short k=0;k<x;k++){
                    temp*=data[i+k][j+k];
                }
                if(temp>max)
                    max=temp;
            }

        }
        //2.右对角线
        for(short i=0;i<count_col;i++){//纵向的次数
            for(short j=0;j<count_row;j++){//横向的次数
                long temp=1;
                for(short k=0;k<x;k++){
                    temp*=data[i+k][m-1-k-j];
                }
                if(temp>max)
                    max=temp;
            }

        }


        System.out.println(max);
    }

}
