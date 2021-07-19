package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class boj2667 {
    static int N;
    static int[][] A;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int a;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N + 2][N + 2];
        visited = new int[N + 2][N + 2];
        ArrayList cnt = new ArrayList();


        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= N; j++) {
                A[i][j] = str.charAt(j - 1) - '0';
            }
        }

        int total = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (A[i][j] == 1 && visited[i][j] == 0) {
                    total++;
                    a=0;
                    dfs(i, j);
                    cnt.add(a);
                }
            }
        }

        System.out.println(total);
        Collections.sort(cnt);
        for (int i = 0; i < total; i++) {
            System.out.println(cnt.get(i));
        }

    }

    static void dfs(int x, int y) {
        if (visited[x][y] == 1)
            return;

        if (A[x][y] == 0)
            return;

        visited[x][y] = 1;
        a++;

        for (int i = 0; i < 4; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }
}
