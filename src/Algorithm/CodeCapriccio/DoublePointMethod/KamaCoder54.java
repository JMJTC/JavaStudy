package Algorithm.CodeCapriccio.DoublePointMethod;

import java.util.Scanner;

/**
 * @author jmjtc
 */
public class KamaCoder54 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)-'a'>=0&&str.charAt(i)-'z'<=0){
                sb.append(str.charAt(i));
            }else{
                sb.append("number");
            }
        }
        System.out.println(sb);
    }
}
