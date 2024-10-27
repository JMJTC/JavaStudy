package algorithm.code_capriccio.Ch4_CharacterString;

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
            char temp=str.charAt(i);
            if(temp-'a'>=0&&temp-'z'<=0){
                sb.append(temp);
            }else{
                sb.append("number");
            }
        }
        System.out.println(sb);
    }
}
