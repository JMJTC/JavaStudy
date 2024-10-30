package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-10-29
 * @Description: 3211. 生成不含相邻零的二进制字符串
 * <a href="https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros/description/">...</a>
 * @Version: 1.0
 */
public class Problem3211 {
    private List<String> ans=new ArrayList<>();
    private StringBuilder path=new StringBuilder();
    private int sum=1;


    public List<String> validStrings(int n) {
        path.append(0);
        backTracking(1,n);
        path.deleteCharAt(path.length()-1);
        path.append(1);
        backTracking(1,n);
        return ans;
    }

    public void backTracking(int index,int total){

        if(sum==total){
            ans.add(path.toString());
            return;
        }
        for(int i=index;i<total;i++){
            sum++;
            if(path.charAt(path.length()-1)=='0'){
                //只能填1
                path.append("1");
                backTracking(i+1,total);
                path.deleteCharAt(path.length()-1);
            }else{
                //两种选择
                for(int j=0;j<2;j++){
                    path.append(j);
                    backTracking(i+1,total);
                    path.deleteCharAt(path.length()-1);
                }
            }
            sum--;
        }
    }


    public static void main(String[] args) {

    }
}
