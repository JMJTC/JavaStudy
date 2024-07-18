package Algorithm.CodeCapriccio.Ch12_GraphTheory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jmjtc
 * <a href="https://kamacoder.com/problempage.php?pid=1170">...</a>
 */
public class KamaCoder98 {
    public static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //邻接矩阵记录有向图
        int[][] graph = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x - 1][y - 1] = 1;
        }
        path.add(0);
        findUsefulPath(graph, 0, n - 1);


        //print answer
        if (ans.isEmpty()) {
            System.out.println(-1);
            return;
        }
        for (List<Integer> temp : ans) {
            for (int j = 0; j < temp.size(); j++) {
                if (j == 0) {
                    System.out.print(temp.get(j) + 1);
                } else {
                    System.out.print(' ');
                    System.out.print(temp.get(j) + 1);
                }
            }
            System.out.println();
        }
    }

    public static void findUsefulPath(int[][] graph, int begin, int end) {
        if (begin == end) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < graph.length; i++) {
            if (graph[begin][i] == 1) {
                path.add(i);
                findUsefulPath(graph, i, end);
                path.remove(path.size() - 1);
            }
        }
    }
}

class Solution2 {
    public static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        //邻接表记录有向图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x - 1).add(y - 1);
        }
        path.add(0);
        findUsefulPath(graph, 0, n - 1);

        //print answer
        if (ans.isEmpty()) {

            System.out.println(-1);
            return;
        }
        for (List<Integer> temp : ans) {

            for (int j = 0; j < temp.size(); j++) {
                if (j == 0) {
                    System.out.print(temp.get(j) + 1);
                } else {
                    System.out.print(' ');
                    System.out.print(temp.get(j) + 1);
                }
            }
            System.out.println();
        }
    }

    public static void findUsefulPath(List<List<Integer>> graph, int begin, int end) {

        if (begin == end) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < graph.get(begin).size(); i++) {
            path.add(graph.get(begin).get(i));
            findUsefulPath(graph, graph.get(begin).get(i), end);
            path.remove(path.size() - 1);
        }
    }
}
