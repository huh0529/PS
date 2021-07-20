package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj14502 {
    static int N, M, max;
    static int[][] A, visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int w1_x = 0; w1_x < N; w1_x++) {
            for (int w1_y = 0; w1_y < M; w1_y++) {

                for (int w2_x = 0; w2_x < N; w2_x++) {
                    for (int w2_y = 0; w2_y < M; w2_y++) {

                        for (int w3_x = 0; w3_x < N; w3_x++) {
                            for (int w3_y = 0; w3_y < M; w3_y++) {

                                if (A[w1_x][w1_y] == 2 || A[w1_x][w1_y] == 1)
                                    continue;

                                if (A[w2_x][w2_y] == 2 || A[w2_x][w2_y] == 1)
                                    continue;

                                if (A[w3_x][w3_y] == 2 || A[w3_x][w3_y] == 1)
                                    continue;

                                if (w2_x == w1_x && w2_y == w1_y)
                                    continue;

                                if (w3_x == w1_x && w3_y == w1_y)
                                    continue;

                                if (w3_x == w2_x && w3_y == w2_y)
                                    continue;

                                A[w1_x][w1_y] = 1;
                                A[w2_x][w2_y] = 1;
                                A[w3_x][w3_y] = 1;

                                visited = new int[N][M];

                                for (int i = 0; i < N; i++)
                                    for (int j = 0; j < M; j++)
                                        visited[i][j]=0;

                                for (int i = 0; i < N; i++) {
                                    for (int j = 0; j < M; j++) {
                                        if (A[i][j] == 2) {
                                            Queue<int[]> q = new LinkedList<>();
                                            q.offer(new int[]{i, j});
                                            visited[i][j] = 1;

                                            while (!q.isEmpty()) {
                                                int[] index = q.poll();

                                                for (int d = 0; d < 4; d++) {
                                                    int x = index[0] + dx[d];
                                                    int y = index[1] + dy[d];

                                                    if (x < 0 || x >= N || y < 0 || y >= M)
                                                        continue;

                                                    if (visited[x][y] == 0 && A[x][y] == 0) {
                                                        visited[x][y] = 1;
                                                        q.offer(new int[]{x, y});
                                                    }
                                                }
                                            }

                                        }
                                    }
                                }


                                int cnt = 0;
                                for (int i = 0; i < N; i++) {
                                    for (int j = 0; j < M; j++) {
                                        if (A[i][j] == 0 && visited[i][j]==0)
                                            cnt++;
                                    }
                                }
                                max = Math.max(max, cnt);


                                A[w1_x][w1_y] = 0;
                                A[w2_x][w2_y] = 0;
                                A[w3_x][w3_y] = 0;
                            }
                        }


                    }
                }


            }
        }

        System.out.println(max);
    }
}
