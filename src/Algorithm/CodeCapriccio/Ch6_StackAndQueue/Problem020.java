package Algorithm.CodeCapriccio.Ch6_StackAndQueue;

import java.util.Stack;

/**
 * @author jmjtc
 */
public class Problem020 {
    public static void main(String[] args) {

    }
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<>();
        //有一一映射的关系时，可以考虑使用HashMap
        for(char c:s.toCharArray()){
            if(stack.empty()){
                stack.push(c);
            }else{
                switch (c){
                    case '}':
                        if(stack.peek()=='{'){
                            stack.pop();
                        }else{
                            return false;
                        }
                        break;
                    case ']':
                        if(stack.peek()=='['){
                            stack.pop();
                        }else{
                            return false;
                        }
                        break;
                    case ')':
                        if(stack.peek()=='('){
                            stack.pop();
                        }else{
                            return false;
                        }
                        break;
                    default:
                        stack.push(c);
                        break;
                }
            }
        }
        return stack.empty();
    }
}
