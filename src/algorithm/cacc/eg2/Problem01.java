package algorithm.cacc.eg2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Problem01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] A = new int[n];
        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int[] result = maxUniqueInSubsequences(n, k, A);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print(" ");
    }

    public static int[] maxUniqueInSubsequences(int n, int k, int[] A) {
        Map<Integer, Integer> count = new HashMap<>();
        int[] result = new int[n - k + 1];
        Deque<Integer> window = new ArrayDeque<>();
        TreeSet<Integer> uniqueElements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                int left = window.pollFirst();
                count.put(left, count.get(left) - 1);
                if (count.get(left) == 0) {
                    uniqueElements.remove(left);
                    count.remove(left);
                }
            }

            window.offerLast(A[i]);
            count.put(A[i], count.getOrDefault(A[i], 0) + 1);
            if (count.get(A[i]) == 1) {
                uniqueElements.add(A[i]);
            } else if (count.get(A[i]) == 2) {
                uniqueElements.remove(A[i]);
            }

            if (i >= k - 1) {
                result[i - k + 1] = uniqueElements.isEmpty() ? -1 : uniqueElements.last();
            }
        }

        return result;
    }
}
