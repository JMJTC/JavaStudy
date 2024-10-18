package algorithm.CodeCapriccio.Ch6_StackAndQueue;

import java.util.*;

/**
 * @author jmjtc
 */
public class Problem347 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,1,1,2,2,3};
        new Problem347().topKFrequent(nums,2);
    }
    //方一:遍历+排序
    //时间复杂度：O(n*logn)
    public int[] topKFrequent(int[] nums, int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> {
            return o2.getValue().compareTo(o1.getValue());//降序
        });
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i).getKey();
        }
        return ans;
    }

    /*Comparator接口说明:
     * 返回负数，形参中第一个参数排在前面；返回正数，形参中第二个参数排在前面
     * 对于队列：排在前面意味着往队头靠
     * 对于堆（使用PriorityQueue实现）：从队头到队尾按从小到大排就是最小堆（小顶堆），
     *                                从队头到队尾按从大到小排就是最大堆（大顶堆）--->队头元素相当于堆的根节点
     * */

    //方二：基于大顶堆的实现
    //时间复杂度：O(n*log k)
    public int[] topKFrequent1(int[] nums, int k){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(((o1, o2) -> o2[1]-o1[1]));//大顶堆
        //对大顶堆所有元素进行排序
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.offer(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll()[0];
        }
        return ans;
    }
}
