package algorithm.tools;

import java.io.*;

/**
 * @author jmjtc
 */
public class TestBuffer {
    private static BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        getSum();
    }

    public static void getSum() throws IOException{
        int a=0,b=0;
        a=Integer.parseInt(in.readLine());
        b=Integer.parseInt(in.readLine());
        out.write(Integer.toString(a+b)+        "\n");
        out.write(a);
        out.flush();
    }
}
