package Algorithm.LeetCode;

public class Problem3033 {
    public static void main(String[] args) {

    }
    public int[][] modifiedMatrix(int[][] matrix) {
        int row=matrix.length;
        int col=matrix[0].length;
        int[][] ans=new int[row][col];
        int[] max=new int[col];
        for(int i=0;i<col;i++){
            int temp=Integer.MIN_VALUE;
            for(int j=0;j<row;j++){
                if(matrix[j][i]>temp){
                    temp=matrix[j][i];
                }
            }
            max[i]=temp;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;i++){
                if(matrix[i][j]==-1){
                    matrix[i][j]=max[j];
                }
            }
        }
        return matrix;
    }
}
