package algorithm.LeetCode;

/**
 * @author jmjtc
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-substring-operation/description/">...</a>
 */
public class Problem2734 {
    public static void main(String[] args) {
        String ans = new Problem2734().smallestString("aa");
        System.out.println(ans);
    }

    public String smallestString(String s) {
        StringBuilder sb = new StringBuilder(s);
        boolean flag=false;
        for (int i = 0; i < s.length(); i++) {
            if (sb.charAt(i) == 'a') {
                continue;
            }
            flag=true;
            int j = i;
            while (j < s.length() && sb.charAt(j) != 'a') {
                sb.setCharAt(j, (char) (sb.charAt(j) - 1));
                j++;
            }
            break;
        }
        if(!flag){
            sb.setCharAt(sb.length()-1, 'z');
        }
        return sb.toString();
    }
}
