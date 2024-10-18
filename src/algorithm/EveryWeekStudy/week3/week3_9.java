package algorithm.EveryWeekStudy.week3;

import java.util.Arrays;

/**
 * @author jmjtc
 */
public class week3_9 {
    public static void main(String[] args){
        int[][] mat=new int[][]{{1,4},{3,2}};
        System.out.println(Arrays.toString(new Solution9().findPeakGrid(mat)));
    }
}

class Solution9 {
    public int[] findPeakGrid(int[][] mat) {
        int x = mat.length;//行数
        int y = mat[0].length;//列数
        int ansX = 0, ansY = y / 2;
        int min = 0, max = y;
        while (true) {
            //先找ansY这一列的最大值
            int max1 = 0;
            for (int i = 0; i < x; i++) {
                if (mat[i][ansY] > max1) {
                    ansX = i;
                    max1 = mat[i][ansY];
                }
            }
            if(ansY<1||ansY>y-2){
                break;
            }
            //比较左右两边的数
            if (max1 > mat[ansX][ansY + 1] && max1 > mat[ansX][ansY - 1]) {
                break;
            } else {//二分
                if (max1 < mat[ansX][ansY + 1]) {
                    min = ansY;
                    ansY = (ansY + max) / 2;
                    continue;
                }
                if (max1 < mat[ansX][ansY - 1]) {
                    max = ansY;
                    ansY = (ansY + min) / 2;
                }
            }
        }
        //边界情况需要再判断一次
        if(ansY==0){
            int max1 = 0;
            for (int i = 0; i < x; i++) {
                if (mat[i][ansY] > max1) {
                    ansX = i;
                    max1 = mat[i][ansY];
                }
            }
            return new int[]{ansX,ansY};
        }
        if(ansY==y-1){
            if(mat[ansX][ansY]<mat[ansX][ansY-1]){
                ansY--;
                int max1 = 0;
                for (int i = 0; i < x; i++) {
                    if (mat[i][ansY] > max1) {
                        ansX = i;
                        max1 = mat[i][ansY];
                    }
                }
            }
            return new int[]{ansX,ansY};
        }
        return new int[]{ansX,ansY};
    }
}
