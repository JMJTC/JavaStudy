package Algorithm.CodeCapriccio.Ch13_MonotoneStack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-16
 * @Description: 每日温度
 * @Version: 1.0
 */
public class Problem739 {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length=temperatures.length;
        int[] ans=new int[length];
        Deque<Integer> stack=new LinkedList<>();
        stack.push(0);
        for(int i=1;i<length;i++){
            if(temperatures[i]<=temperatures[stack.peek()]){//小于栈顶
                stack.push(i);
            }else{
                while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    ans[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }
}
