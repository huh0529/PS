package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1904 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[4];

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[3] = (dp[2] + dp[1])%15746;
            dp[1]=dp[2];
            dp[2]=dp[3];
        }
        if(N==1)
            System.out.println(dp[1]);
        else
            System.out.println(dp[2]);
    }
}