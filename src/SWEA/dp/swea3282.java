package SWEA.dp;

import java.util.Scanner;

public class swea3282 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] v = new int[101];
            int[] c = new int[101];
            int[][] dp = new int[N + 1][K + 1];

            for (int i = 1; i <= N; i++) {
                v[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= K; j++) {
                    if (j - v[i] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + c[i]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, dp[N][K]);
        }
    }
}