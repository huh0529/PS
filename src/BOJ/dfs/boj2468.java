package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2468 {
    static int[][] A;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        A=new int[N+2][N+2];

        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=1;j<=N;j++){
                A[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int max=0;

        for(int h=0;h<100;h++) {
            int cnt = 0;
            visited = new int[N + 2][N + 2];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (A[i][j] > h && visited[i][j] == 0) {
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            max = Math.max(max, cnt);
        }

        System.out.println(max);
    }

    static void dfs(int x, int y, int h) {
        if (visited[x][y] == 1)
            return;

        if (A[x][y] <= h)
            return;

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i], h);
        }
    }
}
