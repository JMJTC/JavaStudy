package algorithm.leetcode;

import java.util.Arrays;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-20
 * @Description: 781. 森林中的兔子
 * @Version: 1.0
 */
public class Problem781 {
    public static void main(String[] args) {

    }

    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int ans = 0;
        int temp = -1;
        int maxCount = -1;
        for (int i = 0; i < answers.length; i++){
            if(answers[i] != temp || maxCount <= 0){
                maxCount = answers[i];
                ans++;
                ans += answers[i];
                temp = answers[i];
            }else{
                maxCount--;
            }
        }
        return ans;
    }
}
