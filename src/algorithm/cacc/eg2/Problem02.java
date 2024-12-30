package algorithm.cacc.eg2;

import algorithm.contestlan.guo13.A;

import java.io.*;
import java.util.*;

/**
 * @Author: jmjtc
 * @CreateTime: 2024-11-25
 * @Description: 构造原理
 * @Version: 1.0
 */
public class Problem02 {
    private static String[] level=new String[]{"s","p","d","f"};
    private static int[] num=new int[]{2,6,10,14};
    private static Map<Integer, List<String>> ans=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(reader.readLine());
        solve(n);
    }
    public static void solve(int n){
        int count=1;
        if(n<=2){
            List<String> list=new ArrayList<>();
            list.add(String.valueOf(n)+level[0]);
            ans.put(count,list);
            return;
        }
        
    }
}
