package algorithm.leetcode;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-30
 * @Description: 2109. 向字符串添加空格
 * @Version: 1.0
 */
public class Problem2109 {
    public static void main(String[] args) {

    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int index1 = 0;
        int index2 = 0;
        for (index1 = 0; index1 < s.length() && index2 < spaces.length; index1++){
            if (index1 != spaces[index2]){
                sb.append(s.charAt(index1));
            }else{
                sb.append(" ");
                index2++;
                index1--;
            }
        }
        while (index1 < s.length()){
            sb.append(s.charAt(index1));
        }
        return sb.toString();
    }
}
