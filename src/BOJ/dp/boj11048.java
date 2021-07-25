package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj11048 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] dp=new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                dp[i][j]=Integer.parseInt(st.nextToken()) + Math.max(dp[i][j-1],Math.max(dp[i-1][j],dp[i-1][j-1]));
            }
        }
        System.out.println(dp[N][M]);
    }
}
