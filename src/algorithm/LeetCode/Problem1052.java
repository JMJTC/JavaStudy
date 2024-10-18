package algorithm.LeetCode;

public class Problem1052 {
    /*由于「技巧」只会将情绪将「生气」变为「不生气」，不生气仍然是不生气。

我们可以先将原本就满意的客户加入答案，同时将对应的 customers[i] 变为 0。

之后的问题转化为：在 customers中找到连续一段长度为 minutes 的子数组
，使得其总和最大。这部分就是我们应用技巧所得到的客户。

*/
    public static void main(String[] args) {

    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes){
        int ans=0;
        for(int i=0;i<customers.length;i++){
            if(grumpy[i]==0){
                ans+=customers[i];
                customers[i]=0;
            }
        }

        int cur=0,max=0;

        // 该部分代码用于计算滑动时间窗口内顾客到达人数的最大值
        for(int i=0;i<customers.length;i++){
            cur+=customers[i]; // 累加当前时间窗口内的顾客到达人数
            if(i>=minutes){
                cur-=customers[i-minutes]; // 如果超过时间窗口大小，减去窗口外的顾客到达人数
            }
            if(cur>max){
                max=cur; // 更新滑动时间窗口内顾客到达人数的最大值
            }
        }

        return ans+max;
    }
}
