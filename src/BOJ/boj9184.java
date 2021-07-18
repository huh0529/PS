package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj9184 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][][] dp = new int[101][101][101];
        int a, b, c;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                return;

            System.out.println("w("+a+", "+b+ ", "+c+ ") = "+w(a+50,b+50,c+50));
        }
    }
    static int[][][] dp=new int[101][101][101];

    static int w(int a,int b,int c){
        if(dp[a][b][c]>0)
            return dp[a][b][c];

        if(a<=50 || b<=50 || c<=50)
            return dp[a][b][c]=1;

        if(a>70 || b>70 || c>70)
            return dp[a][b][c]=w(70,70,70);

        if(a<b && b<c)
            return dp[a][b][c]=w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);

        return dp[a][b][c]=w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
    }
}
