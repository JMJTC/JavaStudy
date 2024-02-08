package Algorithm.CodeCapriccio.Ch6_StackAndQueue;

import java.util.Stack;

/**
 * @author jmjtc
 */
public class MyQueue {
    Stack<Integer> in,out;
    public MyQueue() {
        in=new Stack<>();
        out=new Stack<>();
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        inChangeToOut();
        return out.pop();
    }

    public int peek() {
        inChangeToOut();
        return out.peek();
    }

    public boolean empty() {
        return in.empty()&& out.empty();
    }
    public void inChangeToOut(){
        if(out.empty()){
            while(!in.empty()){
                out.push(in.pop());
            }
        }
    }
}
