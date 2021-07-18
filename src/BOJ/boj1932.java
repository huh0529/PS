package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1932 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] dp=new int[n+1][n+1];

        dp[1][1] = Integer.parseInt(br.readLine());

        for(int i=2;i<=n;i++){
            st = new StringTokenizer(br.readLine());

            dp[i][1] = dp[i-1][1] + Integer.parseInt(st.nextToken());
            for (int j = 2; j <= i-1; j++)
                dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + Integer.parseInt(st.nextToken());
            dp[i][i] = dp[i-1][i-1] + Integer.parseInt(st.nextToken());
        }

        System.out.println(Arrays.stream(dp[n]).max().getAsInt());
    }
}
