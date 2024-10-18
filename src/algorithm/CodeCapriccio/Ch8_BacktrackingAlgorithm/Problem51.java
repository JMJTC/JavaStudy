package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jmjtc
 */
public class Problem51 {
    private List<List<String>> ans=new ArrayList<>();
    private LinkedList<String> path=new LinkedList<>();
    //private StringBuilder temp=new StringBuilder();//记录每一行
    private char[][] broad;//记录棋盘

    public static void main(String[] args) {
        new Problem51().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n){
        broad=new char[n][n];
        for (char[] c : broad) {
            Arrays.fill(c, '.');
        }


        backTracking(n,0);
        return ans;
    }

    public void backTracking(int n,int index){
        if(path.size()==n){
            ans.add(new ArrayList<>(path));
            return;
        }
        //这里只要一层循环就可以了
            for(int j=0;j<n;j++){

                if(isValid(index,j)) {
                    StringBuilder temp=new StringBuilder();//记录每一行
                    temp.append(".".repeat(n));
                    broad[index][j]='Q';
                    temp.setCharAt(j,'Q');
                    path.add(temp.toString());
                    backTracking(n,index+1);
                    //回溯
                    temp.setCharAt(j,'.');
                    path.removeLast();
                    broad[index][j]='.';
                }

            }

    }

    public boolean isValid(int i,int j){
        //检查列
        for(int k=0;k<broad.length;k++){
            if(broad[k][j]=='Q'){
                return false;
            }
        }

        //检查45度角
        for(int row=i-1,col=j-1;row>=0&&col>=0;row--,col--){
            if(broad[row][col]=='Q'){
                return false;
            }
        }

        //135度角
        for(int row=i-1,col=j+1;row>=0&&col<broad.length;row--,col++){
            if(broad[row][col]=='Q'){
                return false;
            }
        }
        return true;
    }


}
