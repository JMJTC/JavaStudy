package algorithm.code_capriccio.Ch6_StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

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
