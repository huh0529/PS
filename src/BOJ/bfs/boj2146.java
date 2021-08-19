package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2146 {
    static int N;
    static int[][][] A;
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N][N][2];
        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j][0] = Integer.parseInt(st.nextToken());
            }
        }


        //육지 구별
        int bridgeNum = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (A[i][j][0] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    visited[i][j] = 1;
                    A[i][j][0] = bridgeNum;
                    while (!q.isEmpty()) {
                        int index[] = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int x = index[0] + dx[k];
                            int y = index[1] + dy[k];

                            if (x < 0 || x >= N || y < 0 || y >= N)
                                continue;

                            if (visited[x][y] == 0 && A[x][y][0] == 1) {
                                visited[x][y] = 1;
                                A[x][y][0] = bridgeNum;
                                q.offer(new int[]{x, y});
                            }
                        }
                    }
                    bridgeNum++;
                }
            }
        }

        //육지 사이 거리 - while 돌때마다 육지마다 크기가 1씩 증가 그러다 육지마 서로만나면
        int min=10000;
        boolean flag=true;
        int cnt=0;  //육지로부터 거리
        while(flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j][0] > 0 && A[i][j][1] == cnt) {
                        for (int k = 0; k < 4; k++) {
                            int x = i + dx[k];
                            int y = j + dy[k];

                            if (x < 0 || x >= N || y < 0 || y >= N)
                                continue;

                            if (A[x][y][0] == 0) {
                                A[x][y][0] = A[i][j][0];
                                A[x][y][1] = A[i][j][1] + 1;
                            } else {
                                if (A[x][y][0] != A[i][j][0]) {
                                    int len = A[x][y][1] + A[i][j][1];
                                    min = Math.min(min, len);
                                    flag=false;
//                                System.out.println(min);
//                                System.exit(0);
                                }
                            }
                        }
                    }

                }
            }
            cnt++;
        }
        System.out.println(min);
    }
}
