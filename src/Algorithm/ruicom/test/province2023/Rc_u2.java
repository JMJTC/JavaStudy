package Algorithm.ruicom.test.province2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author jmjtc
 */
public class Rc_u2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();//已知的饮料
        int m= sc.nextInt();//需要定级的饮料
        String[] names=new String[n];
        Map<String,Character> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            names[i]=sc.next();
            char c=sc.next().charAt(0);
            hash.put(names[i],c);
        }

        for(int i=0;i<m;i++){
            StringBuilder ans=new StringBuilder();
            String name= sc.next();
            int index=0;
            StringBuilder sb=new StringBuilder();
            sb.append(name.charAt(index++));
            while(index<=name.length()){
                if(hash.containsKey(sb.toString())){
                    ans.append(hash.get(sb.toString()));
                    sb=new StringBuilder();
                    if(index<name.length()){
                        sb.append(name.charAt(index++));
                    }else{
                        break;
                    }
                }else{
                    if(index==name.length()){
                        index++;
                        ans=new StringBuilder("D");
                    }else{
                        sb.append(name.charAt(index++));
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
