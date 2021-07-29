package BOJ.플로이드와샬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2458 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n + 1][n + 1];

        int INF=1000;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                graph[i][j]=INF;
                if(i==j)
                    graph[i][j]=0;
            }
        }

        for (int M = 0; M < m; M++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            graph[i][j] = 0;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag =true;
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                if (graph[i][j] == INF && graph[j][i] == INF) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                cnt++;
        }
        System.out.println(cnt);
    }
}
