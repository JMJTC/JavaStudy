package algorithm.code_capriccio.Ch6_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author jmjtc
 */
public class Problem150 {
    public static void main(String[] args) {

    }

    public int evalRPN(String[] tokens){
        Deque<Integer> stack=new LinkedList<>();
        for (String token : tokens) {
            switch (token) {
                case "+": {
                    int b = stack.pop();
                    int a = stack.pop();
                    a = a + b;
                    stack.push(a);
                }
                break;
                case "-": {
                    int b = stack.pop();
                    int a = stack.pop();
                    a = a - b;
                    stack.push(a);
                }
                break;
                case "*": {
                    int b = stack.pop();
                    int a = stack.pop();
                    a = a * b;
                    stack.push(a);
                }
                break;
                case "/": {
                    int b = stack.pop();
                    int a = stack.pop();
                    a = a / b;
                    stack.push(a);
                }
                break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
