package algorithm.acwing.p1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Author: jmjtc
 * @CreateTime: 2025-02-03
 * @Description: A+B
 * @Version: 1.0
 */
public class Problem01 {
    public static void main(String[] args) throws Exception{
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        System.out.println(a + b);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        bw.write(a + b + "\n");
        bw.flush();
    }
}
