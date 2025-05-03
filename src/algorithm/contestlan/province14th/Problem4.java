package algorithm.contestlan.province14th;


import java.util.*;
import java.io.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-04-02
 * @Description: 不完整的算式
 * @Version: 1.0
 */
public class Problem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int qIndex = s.indexOf('?');

        if (qIndex == 0) { // A 被擦除
            char op = s.charAt(1);
            int b = parseNumber(s, 3, s.indexOf('=', 3) - 1);
            int c = Integer.parseInt(s.substring(s.indexOf('=') + 1));
            int a;
            switch (op) {
                case '+':
                    a = c - b;
                    break;
                case '-':
                    a = c + b;
                    break;
                case '*':
                    a = c / b;
                    break;
                case '/':
                    a = c * b;
                    break;
                default:
                    return;
            }
            System.out.println(a);
        } else if (isOperatorPosition(qIndex, s)) { // 运算符被擦除
            int a = parseNumber(s, 0, qIndex - 1);
            int b = parseNumber(s, qIndex + 2, s.indexOf('=', qIndex + 2) - 1);
            int c = Integer.parseInt(s.substring(s.indexOf('=') + 1));
            if (a + b == c) {
                System.out.println('+');
            } else if (a - b == c) {
                System.out.println('-');
            } else if (a * b == c) {
                System.out.println('*');
            } else if (a / b == c) {
                System.out.println('/');
            }
        } else if (qIndex < s.indexOf('=')) { // B 被擦除
            int a = parseNumber(s, 0, qIndex - 1);
            char op = s.charAt(qIndex + 1);
            int c = Integer.parseInt(s.substring(s.indexOf('=') + 1));
            int b;
            switch (op) {
                case '+':
                    b = c - a;
                    break;
                case '-':
                    b = a - c;
                    break;
                case '*':
                    b = c / a;
                    break;
                case '/':
                    b = a / c;
                    break;
                default:
                    return;
            }
            System.out.println(b);
        } else { // C 被擦除
            int a = parseNumber(s, 0, s.indexOf(' '));
            char op = s.charAt(s.indexOf(' ') + 1);
            int b = parseNumber(s, s.indexOf(' ') + 3, qIndex - 1);
            int c;
            switch (op) {
                case '+':
                    c = a + b;
                    break;
                case '-':
                    c = a - b;
                    break;
                case '*':
                    c = a * b;
                    break;
                case '/':
                    c = a / b;
                    break;
                default:
                    return;
            }
            System.out.println(c);
        }
    }

    private static boolean isOperatorPosition(int qIndex, String s) {
        return (s.charAt(qIndex - 1) >= '0' && s.charAt(qIndex - 1) <= '9') &&
                (s.charAt(qIndex + 1) >= '0' && s.charAt(qIndex + 1) <= '9');
    }

    private static int parseNumber(String s, int start, int end) {
        return Integer.parseInt(s.substring(start, end + 1));
    }
}
