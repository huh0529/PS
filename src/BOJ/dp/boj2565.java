package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2565 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[501];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a] = b;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 500; i++) {
            if (A[i] > 0)
                list.add(A[i]);
        }

        int[] dp = new int[501];

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (list.get(j) > list.get(i))
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(n - (max + 1));
    }
}
