package algorithm.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-03-23
 * @Description: 2116. 判断一个括号字符串是否有效
 * @Version: 1.0
 */
public class Problem2116 {
    public static void main(String[] args) {
        String s = "(((())(((())";
        String locked = "111111010111";
        System.out.print(new Problem2116().canBeValid(s, locked));
    }

    // *)*)**
    public boolean canBeValid(String s, String locked) {
        String reverses = new StringBuilder(s).reverse().toString();
        String reverseLocked = new StringBuilder(locked).reverse().toString();
        return isValid(s, locked, '(') || isValid(reverses, reverseLocked, ')');
    }

    public boolean isValid(String s, String locked, char sym) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        //优先满足locked[i]不为0的s
        char[] clocked = locked.toCharArray();
        for (int i = 0; i < length; i++) {
            if (clocked[i] == '0') {
                stack.push('*');
            } else {
                if (s.charAt(i) == sym) {
                    stack.push(s.charAt(i));
                } else {
                    if (!stack.isEmpty() && (stack.peek() == sym || stack.peek() == '*')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }

            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        Deque<Character> util = new LinkedList<>();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == sym) {
                if (util.isEmpty()) {
                    return false;
                }
                util.pop();
            } else {
                util.push(c);
            }
        }
        return true;
    }


    //正解
    public boolean canBeValid1(String s, String locked) {
        // 检查字符串长度是否为偶数，并且正向和反向检查字符串是否有效
        return s.length() % 2 == 0 && isValid(s, locked, '(') && isValid(new StringBuilder(s).reverse().toString(), new StringBuilder(locked).reverse().toString(), ')');
    }

    public boolean isValid1(String s, String locked, char open) {
        int balance = 0; // 平衡因子，用于记录括号的匹配情况
        int wildcards = 0; // 通配符数量，用于记录未锁定字符的数量
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') { // 如果字符是锁定的
                if (s.charAt(i) == open) { // 如果锁定字符是打开括号
                    balance++; // 平衡因子加1
                } else {
                    balance--; // 否则平衡因子减1
                }
            } else {
                wildcards++; // 如果字符未锁定，通配符数量加1
            }
            if (balance + wildcards < 0) { // 如果当前平衡因子加上通配符数量小于0，说明无法匹配
                return false;
            }
        }
        return Math.abs(balance) <= wildcards; // 返回平衡因子的绝对值是否小于等于通配符数量
    }
}
