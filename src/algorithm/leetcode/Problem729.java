package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-01-02
 * @Description: 729. 我的日程安排表 I
 * @Version: 1.0
 */
public class Problem729 {
    public static void main(String[] args) {

    }

}

class MyCalendar {
    private int[][] data;
    private int index=0;

    public MyCalendar() {
        data=new int[1000][2];
    }

    public boolean book(int startTime, int endTime) {
        for(int i=0;i<index;i++){
            if(data[i][0]<endTime&&data[i][1]>startTime){
                return false;
            }
        }
        data[index][0]=startTime;
        data[index][1]=endTime;
        index++;
        return true;
    }
}
