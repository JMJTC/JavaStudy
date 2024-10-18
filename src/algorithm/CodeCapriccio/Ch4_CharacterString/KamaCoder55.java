package algorithm.CodeCapriccio.Ch4_CharacterString;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class KamaCoder55 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String str=sc.next();
        int index=str.length()-n;
        StringBuilder ans=new StringBuilder();
        for(int i=index;i<str.length();i++){
            ans.append(str.charAt(i));
        }
        for(int i=0;i<index;i++){
            ans.append(str.charAt(i));
        }
        System.out.println(ans);
    }

    //方二：
    public  void Main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String s = in.nextLine();

        int len = s.length();  //获取字符串长度
        char[] chars = s.toCharArray();
        reverseString(chars, 0, len - 1);  //反转整个字符串
        reverseString(chars, 0, n - 1);  //反转前一段字符串，此时的字符串首尾尾是0,n - 1
        reverseString(chars, n, len - 1);  //反转后一段字符串，此时的字符串首尾尾是n,len - 1

        System.out.println(chars);

    }

    public static void reverseString(char[] ch, int start, int end) {
        //异或法反转字符串，参照题目 344.反转字符串的解释
        while (start < end) {
            ch[start] ^= ch[end];
            ch[end] ^= ch[start];
            ch[start] ^= ch[end];
            start++;
            end--;
        }
    }
}
