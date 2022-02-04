package SWEA.힙;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class swea1249 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int n = sc.nextInt();
            int answer = Integer.MAX_VALUE;

            int[][] map = new int[n][n];
            int[][] dp = new int[n][n];
            boolean[][] visited = new boolean[n][n];
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};


            for (int i = 0; i < n; i++) {
                String str = sc.next();
                for (int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j) - '0';
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }


//            PriorityQueue<int[]> q = new PriorityQueue<>();
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {0, 0});
            visited[0][0] = true;
            dp[0][0] = 0;

            while (!q.isEmpty()) {
                int[] idx = q.poll();

                if (idx[0] == n - 1 && idx[1] == n - 1) {
                    answer = dp[idx[0]][idx[1]];
                }

                if (answer <= dp[idx[0]][idx[1]]) {
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int x = idx[0] + dx[i];
                    int y = idx[1] + dy[i];

                    if (x < 0 || y < 0 || x >= n || y >= n) {
                        continue;
                    }

                    if(!visited[x][y] || map[x][y] + dp[idx[0]][idx[1]] < dp[x][y]) {
                            dp[x][y] = map[x][y] + dp[idx[0]][idx[1]];
                            visited[x][y] = true;
                            q.add(new int[]{x, y});
                    }
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}
