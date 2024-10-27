package algorithm.code_capriccio.Ch6_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jmjtc
 */
public class Problem1047 {
    public static void main(String[] args) {
        System.out.println(new Problem1047().removeDuplicates("abbaca"));
    }
    public String removeDuplicates(String s){
        Deque<Character> stack=new LinkedList<>();
        for(char ch: s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                if(stack.peek()==ch){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.poll());
        }
        return sb.toString();
    }
}
