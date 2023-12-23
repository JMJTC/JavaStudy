package Algorithm.LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author jmjtc
 */
public class Problem1962 {
}

class Problem1962_Solution1{
    public int minStoneSum(int[] piles, int k) {
        //初始化堆
        for(int i=piles.length/2-1;i>=0;i--){//tips：下标从0开始，故需要-1,实际做题时可以简单推导一下
            siftDown(piles,piles.length,i);
        }
        //建大根堆，每次取出最大的
        for(int i=0;i<k;i++){
            siftDown(piles,piles.length,0);
            piles[0]=piles[0]-piles[0]/2;
        }
        int ans=0;
        for (int pile : piles) {
            ans += pile;
        }
        return ans;
    }
    public void siftDown(int[] piles,int length,int index){
        while(true){
            //判断节点index,l,r,中值最大的节点，记为ma
            int l=2*index+1;
            int r=2*index+2;
            int ma=index;
            if(l<length&&piles[l]>piles[ma]){
                ma=l;
            }
            if(r<length&&piles[r]>piles[ma]){
                ma=r;
            }
            //若节点i最大或索引l,r越界，则无须继续堆化，跳出
            if(ma==index){
                break;
            }
            //交换两节点
            int temp=piles[index];
            piles[index]=piles[ma];
            piles[ma]=temp;
            //循环向下堆化
            index=ma;
        }
    }
}

//使用优先队列,底层实现为堆
class Problem1962_Solution2{
    public int minStoneSum(int[] piles, int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        //自定义比较器,大于0交换，小于0不交换,这里实现了一个递减的队列
        //将piles的元素入队
        for(int pile:piles){
            pq.offer(pile);
        }
        for(int i=0;i<k;i++){
            int temp=pq.poll();
            temp=temp-(temp>>1);
            pq.offer(temp);
        }
        int ans=0;
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}
