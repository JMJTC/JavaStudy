package algorithm.CodeCapriccio.Ch8_BacktrackingAlgorithm;

import java.util.*;

/**
 * @author jmjtc
 */
public class Problem37 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Problem37().solveSudoku(board);
    }

    char[][] tempBoard=new char[9][9];

    public void solveSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            System.arraycopy(board[i], 0, tempBoard[i], 0, 9);
        }
        backTracking(board,0,0);
        System.out.print(Arrays.deepToString(board));
    }

    public void backTracking(char[][] board,int row,int col){
        if(row==9){
            for(int i=0;i<9;i++){
                System.arraycopy(tempBoard[i], 0, board[i], 0, 9);
            }
            return;
        }
        for(char i='1';i<='9';i++){
            while(tempBoard[row][col]!='.'){
                row=row+(col+1)/9;
                col=(col+1)%9;
                if(row==9){
                    for(int j=0;j<9;j++){
                        System.arraycopy(tempBoard[j], 0, board[j], 0, 9);
                    }
                    return;
                }
            }
            if(isValid(tempBoard,i,row,col)){
                tempBoard[row][col]=i;
                backTracking(board,row+(col+1)/9,(col+1)%9);
                //回溯
                tempBoard[row][col]='.';
            }
        }
    }

    public boolean isValid(char[][] tempBoard,char num,int row,int col){
        //行,列
        //行,列
        for(int i=0;i<9;i++){
            if(tempBoard[row][i]==num){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(tempBoard[i][col]==num){
                return false;
            }
        }
        //所在单元格
        int x=row/3,y=col/3;
        x*=3;y*=3;//找到所在格的左下角
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tempBoard[x+i][y+j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}


class ProblemSolution1{
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Problem37().solveSudoku(board);
    }

    char[][] tempBoard=new char[9][9];

    public void solveSudoku(char[][] board) {

        backTracking(board);
        System.out.print(Arrays.deepToString(board));
    }

    public boolean backTracking(char[][] board){
        //「一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        // 一行一列确定下来之后，递归遍历这个位置放9个数字的可能性！」
        for (int i = 0; i < 9; i++){ // 遍历行
            for (int j = 0; j < 9; j++){ // 遍历列
                if (board[i][j] != '.'){ // 跳过原始数字
                    continue;
                }
                for (char k = '1'; k <= '9'; k++){ // (i, j) 这个位置放k是否合适
                    if (isValid( board,k,i,j)){
                        board[i][j] = k;
                        if (backTracking(board)){ // 如果找到合适一组立刻返回
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
                // 因为如果一行一列确定下来了，这里尝试了9个数都不行，说明这个棋盘找不到解决数独问题的解！
                // 那么会直接返回， 「这也就是为什么没有终止条件也不会永远填不满棋盘而无限递归下去！」
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    public boolean isValid(char[][] tempBoard,char num,int row,int col){
        //行,列
        for(int i=0;i<9;i++){
            if(tempBoard[row][i]==num){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if(tempBoard[i][col]==num){
                return false;
            }
        }
        //所在单元格
        int x=row/3,y=col/3;
        x*=3;y*=3;//找到所在格的左下角
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(tempBoard[x+i][y+j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}