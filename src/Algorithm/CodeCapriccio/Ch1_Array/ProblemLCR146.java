package Algorithm.CodeCapriccio.Ch1_Array;

/**
 * @author jmjtc
 */
public class ProblemLCR146 {
    public static void main(String[] args) {

    }
}

class ProblemLCR146_Solution{
    public int[] spiralArray(int[][] array) {
        if(array==null||array.length==0||array[0].length==0){
            return new int[0];
        }
        int rows=array.length,columns=array[0].length;
        boolean[][] visited=new boolean[rows][columns];
        int total=rows*columns;
        int[] order=new int[total];
        int row=0,column=0;
        int[][] directions={{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex=0;
        for(int i=0;i<total;i++){
            order[i]=array[row][column];
            visited[row][column]=true;
            int nextRow=row+directions[directionIndex][0],nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
