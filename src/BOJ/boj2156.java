package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = A[1];

        if (n > 1)
            dp[2] = A[2] + dp[1];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 3] + A[i - 1], dp[i - 2]) + A[i]);
        }

        System.out.println(dp[n]);
    }
}
