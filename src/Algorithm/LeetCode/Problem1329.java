package Algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem1329 {
    public static void main(String[] args) {

    }

    public int[][] diagonalSort(int[][] mat) {
        int rowLength=mat.length;
        int colLength=mat[0].length;
        List<Integer> list=new ArrayList<>();
        //从左下到右上
        //1.最左边一列
        for(int i=rowLength-1;i>=0;i--){
            list.clear();
            for(int j=i,k=0;j<rowLength&&k<colLength;j++,k++){
                list.add(mat[j][k]);
            }
            list.sort((a,b)-> a-b);//升序
            //赋值
            int index=0;
            for(int j=i,k=0;j<rowLength&&k<colLength;j++,k++){
                mat[j][k]=list.get(index++);
            }
        }
        //2.最上面一行
        for(int i=0;i<colLength;i++){
            list.clear();
            for(int j=i,k=0;j<colLength&&k<rowLength;j++,k++){
                list.add(mat[k][j]);
            }
            list.sort((a,b)-> a-b);//升序
            //赋值
            int index=0;
            for(int j=i,k=0;j<colLength&&k<rowLength;j++,k++){
                mat[k][j]=list.get(index++);
            }
        }
        return mat;
    }
}
