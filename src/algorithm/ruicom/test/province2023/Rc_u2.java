package algorithm.ruicom.test.province2023;

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
        //输入已知饮料的名字和定级
        for(int i=0;i<n;i++){
            names[i]=sc.next();
            char c=sc.next().charAt(0);
            hash.put(names[i],c);
        }

        //输入需要定级的饮料
        for(int i=0;i<m;i++){
            StringBuilder ans=new StringBuilder();
            String name= sc.next();
            int index=0;
            StringBuilder sb=new StringBuilder();
            sb.append(name.charAt(index++));
            //遍历需要定级的饮料
            while(index<=name.length()){
                //如果当前字符串在已知饮料中，则添加定级并清空StringBuilder
                if(hash.containsKey(sb.toString())){
                    ans.append(hash.get(sb.toString()));
                    sb=new StringBuilder();
                    if(index<name.length()){
                        sb.append(name.charAt(index++));
                    }else{
                        break;
                    }
                //如果当前字符串不在已知饮料中，则添加D并清空StringBuilder
                }else{
                    if(index==name.length()){
                        index++;
                        ans=new StringBuilder("D");
                    }else{
                        sb.append(name.charAt(index++));
                    }
                }
            }
            //输出定级结果
            System.out.println(ans);
        }
    }
}
