package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2178 {
    static int N, M;
    static int[][] A;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 2][M + 2];
        visited = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            String str = br.readLine();

            for (int j = 1; j <= M; j++) {
                A[i][j] = str.charAt(j - 1) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {1,1});

        visited[1][1]=1;

        while (!q.isEmpty()) {
            int index[]=q.poll() ;
            int x=index[0];
            int y=index[1];

            for (int i = 0; i < 4; i++) {
                if (visited[x + dx[i]][y + dy[i]] == 0 && A[x + dx[i]][y + dy[i]] == 1) {
                    visited[x + dx[i]][y + dy[i]] = visited[x][y] + 1;
                    q.offer(new int[] {x + dx[i],y + dy[i]});
                }
            }
        }

        System.out.println(visited[N][M]);
    }
}
