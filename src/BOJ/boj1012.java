package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1012 {
    static int M, N, K, cnt;
    static int[][] map, visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M + 2][N + 2];
            visited = new int[M + 2][N + 2];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int x = 1 + Integer.parseInt(st.nextToken());
                int y = 1 + Integer.parseInt(st.nextToken());

                map[x][y] = 1;
            }

            cnt = 0;
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 1 && visited[i][j] == 0) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        if (visited[x][y] == 1 || map[x][y] == 0)
            return;

        visited[x][y] = 1;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }

}
