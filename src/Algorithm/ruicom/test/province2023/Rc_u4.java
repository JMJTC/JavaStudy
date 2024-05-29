package Algorithm.ruicom.test.province2023;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Rc_u4 {
    public static List<Integer> ansList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        input(sc);
    }

    public static void input(Scanner sc){
        int n= sc.nextInt();
        String[][] data=new String[n][4];
        for(int i=0;i<n;i++){
            for(int j=0;j<4;j++){
                data[i][j]=sc.next();
            }
        }

        for(int i=0;i<n;i++){
            ansList.add(i);
            backTranking(data,i,0);
        }

    }

    public static void backTranking(String[][] data,int start,int count){
        String temp1=data[start][0];
        String status=data[start][1];
        String temp2=data[start][2];
        String temp3=data[start][3];
    }
}
