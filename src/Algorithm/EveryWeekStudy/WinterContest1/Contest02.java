package Algorithm.EveryWeekStudy.WinterContest1;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Contest02 {
    public static boolean isValid(String str){
        //利用栈
        char[] stack=new char[str.length()];
        int top=0;
        for(int i=0;i<str.length();i++){
            switch (str.charAt(i)){
                case '(':
                case '[':
                case'{':stack[top++]=str.charAt(i);
                break;
                case '}':if(top>0&&stack[top-1]=='{'){
                    top--;
                }else{
                    stack[top++]=str.charAt(i);
                }
                break;
                case ']':if(top>0&&stack[top-1]=='['){
                    top--;
                }else{
                    stack[top++]=str.charAt(i);
                }
                break;
                case ')':if(top>0&&stack[top-1]=='('){
                    top--;
                }else{
                    stack[top++]=str.charAt(i);
                }
            }
        }
        return top == 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n= sc.nextInt();
        for(int i=0;i<n;i++){
            String str= sc.next();
            if(isValid(str)){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
    }
}
