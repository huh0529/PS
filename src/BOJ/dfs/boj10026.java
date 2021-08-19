package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj10026 {
    static int N;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void dfs(char[][] X, int i, int j, char c) {
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];

            if (x < 0 || x >= N || y < 0 || y >= N)
                continue;

            if (!visited[x][y] && X[x][y] == c) {
                dfs(X, x, y, c);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] A = new char[N][N];
        char[][] B = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < N; j++) {
                A[i][j] = str.charAt(j);
                B[i][j] = str.charAt(j);
                if (B[i][j] == 'G')
                    B[i][j] = 'R';
            }
        }

        int cnt1 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(A, i, j, A[i][j]);
                    cnt1++;
                }
            }
        }


        visited = new boolean[N][N];
        int cnt2 = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(B, i, j, B[i][j]);
                    cnt2++;
                }
            }
        }
        System.out.println(cnt1 + " " + cnt2);
    }
}
