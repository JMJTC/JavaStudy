package algorithm.EveryWeekStudy.week2;

import java.util.Arrays;
import java.util.Comparator;

public class week2_6 {
    public static int findMinArrowShots(int[][] points) {
        //对每个point的[x1,x2]的x2进行升序排序
        Arrays.sort(points,new Comparator<int []>(){
            public int compare(int[] points1,int []points2){
                if(points1[1]>points2[1]) {
                    return 1;
                } else if(points1[1]<points2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        //使用自定义的排序方法，自定义排序方法需要实现java.util.Comparetor接口中的compare方法
        //Lambda表达式,可简化
        // Arrays.sort(points,(a,b)->a[1]<b[1]?-1:a[1]>b[1]?1:0);
        //Arrays.sort(points,(o1,o2)->Integer.compare(o1[1],o2[1]));
        int count=0;
        for(int i=0;i<points.length;i++){
            count++;
            //射入气球的右边界
            int arrow = points[i][1];
            //if 这个arrow能射中下一歌气球(大于下一气球的左边界)， i++,
            while(i+1<points.length && arrow>=points[i+1][0]){
                i++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int [][]points = {{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }
}
