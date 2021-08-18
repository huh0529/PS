package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class E {
    int x;
    int y;

    E(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class boj2638 {
    static int N, M;
    static int[][] A = new int[102][102];
    static int[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<E> q = new LinkedList<>();
    static int total = 0;

    static void makeAir2() {
        q.add(new E(0, 0));

        visited = new int[102][102];
        visited[0][0] = 1;
        A[0][0] = 2;

        while (!q.isEmpty()) {
            E e = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = e.x + dx[i];
                int y = e.y + dy[i];

                if (x < 0 || x > N + 1 || y < 0 || y > M + 1) {
                    continue;
                }

                if (visited[x][y] == 0 && (A[x][y] == 0 || A[x][y] == 2)) {
                    A[x][y] = 2;
                    visited[x][y] = 1;
                    q.add(new E(x, y));
                }
            }
        }
    }

    static void deleteCheese() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (A[i][j] == 1) {
                    int cnt = 0;

                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (A[x][y] == 2)
                            cnt++;
                    }

                    if (cnt >= 2) {
                        A[i][j] = 0;
                        total--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 1)
                    total++;
            }
        }

        int hour = 0;
        while (total > 0) {
            hour++;
            makeAir2();
            deleteCheese();
        }
        System.out.println(hour);
    }
}