package SWEA.그래프탐색;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1461 {
    static int N;
    static int[][] cell;
    static List<int[]> core;
    static int len;
    static int maxCnt;
    static int minLen;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            N = sc.nextInt();
            cell = new int[N][N];
            core = new ArrayList<>();
            len = 0;
            maxCnt = Integer.MIN_VALUE;
            minLen = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cell[i][j] = sc.nextInt();

                    if (cell[i][j] == 1) {
                        if (i == 0 || j == 0 || i == N - 1 || j == N - 1) {
                            continue;
                        }
                        core.add(new int[]{i, j});
                    }
                }
            }

            dfs(0, 0);


            System.out.println("#" + test_case + " " + minLen);
        }
    }

    static boolean check(int X, int Y, int i) {
        int x = X;
        int y = Y;
        boolean flag = true;

        while (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
            x += dx[i];
            y += dy[i];
            if (cell[x][y] == 1 || cell[x][y] == 2) {
                flag = false;
                break;
            }
        }

        x = X;
        y = Y;

        if (flag) {
            while (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
                x += dx[i];
                y += dy[i];
                cell[x][y] = 2;
                len++;
            }
        }
        return flag;

    }

    static void init(int x, int y, int i) {
        while (x + dx[i] >= 0 && x + dx[i] < N && y + dy[i] >= 0 && y + dy[i] < N) {
            x += dx[i];
            y += dy[i];
            cell[x][y] = 0;
            len--;
        }
    }

    static void dfs(int k, int cnt) {
        if (k == core.size()) {
            if (cnt > maxCnt) {
                maxCnt = cnt;
                minLen = len;
            } else if (maxCnt == cnt) {
                minLen = Math.min(minLen, len);
            }
            return;
        }

        int x = core.get(k)[0];
        int y = core.get(k)[1];

        for (int i = 0; i < 4; i++) {
            if (check(x, y, i)) {
                dfs(k + 1, cnt + 1);
                init(x, y, i);
            } else {
                dfs(k + 1, cnt);
            }
        }
    }
}
