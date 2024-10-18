package algorithm.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jmjtc
 */
public class Problem1631 {
}
class Problem1631Solution {
    int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;//行
        int n=heights[0].length;//列
        int left=0,right=999999,ans=0;
        while(left<=right){
            int mid=(left+right)/2;
            Queue<int[]> queue= new LinkedList<>();
            queue.offer(new int[]{0,0});
            boolean[] seen=new boolean[m*n];
            seen[0]=true;
            while(!queue.isEmpty()){
                int[] cell=queue.poll();
                int x=cell[0],y=cell[1];
                for(int i=0;i<4;++i){
                    int nx=x+dirs[i][0];
                    int ny=y+dirs[i][1];
                    if(nx>=0&&nx<m&&ny>=0&&ny<n&&!seen[nx*n+ny]&&Math.abs(heights[x][y]-heights[nx][ny])<=mid){
                        queue.offer(new int[]{nx,ny});
                        seen[nx*n+ny]=true;
                    }
                }
            }
            if(seen[m*n-1]){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}