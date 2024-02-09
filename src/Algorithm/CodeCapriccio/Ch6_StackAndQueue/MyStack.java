package Algorithm.CodeCapriccio.Ch6_StackAndQueue;

import javax.print.DocFlavor;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jmjtc
 */
public class MyStack {
    Deque<Integer> stack;
    public MyStack() {
        stack=new LinkedList<>();
    }

    public void push(int x) {
        stack.offer(x);
    }

    public int pop() {
        return stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public boolean empty() {
        return stack.isEmpty();
    }
}
