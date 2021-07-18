package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = A[1];
        if (N >= 2)
            dp[2] = dp[1] + A[2];

        for (int i = 3; i <= N; i++) {
            dp[i] = A[i] + Math.max(dp[i - 2], dp[i - 3] + A[i - 1]);
        }

        System.out.println(dp[N]);
    }
}
