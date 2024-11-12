package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-12
 * @Description: 3258. 统计满足 K 约束的子字符串数量 I
 * @Version: 1.0
 */
public class Problem3258 {
    public static void main(String[] args) {

    }

    //时间复杂度：O(n*n) 枚举
    public int countKConstraintSubstrings(String s, int k){
        int ans=0;
        int length=s.length();
        for(int i=0;i<length;i++){
            int[] count=new int[2];
            for(int j=i;j<length;j++){
                count[s.charAt(j)-'0']++;
                if(count[0]>k&&count[1]>k){
                    break;
                }
                ans++;
            }
        }
        return ans;
    }

    //方二 滑动窗口+前缀
    public int countKConstraintSubstrings2(String s, int k){
        //0的ascll 为偶数
        int ans=0;
        char[] arr=s.toCharArray();
        int length=arr.length;
        int[] count=new int[]{0,0};
        int left=0;
        for(int i=0;i<length;i++){
            count[arr[i]&1]++;
            while(count[0]>k&&count[1]>k){
                count[arr[left++]&1]--;
            }
            ans+=i-left+1;//以i为右节点，left为左节点的子串
        }
        return ans;
    }
}
