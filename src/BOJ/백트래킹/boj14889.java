package BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14889 {
    static int N, min = 10000;
    static int[][] A;
    static int[] team1, team2;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        team1 = new int[N / 2];
        team2 = new int[N / 2];

        isUsed = new boolean[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        func(0);
        System.out.println(min);
    }

    static void func(int n) {
        if (n == N / 2) {
            int cnt1 = 0;
            int cnt2 = 0;

            for (int i = 0; i < N; i++) {
                if (cnt2 >= N / 2)
                    break;
                if (team1[cnt1] != i) {
                    team2[cnt2] = i;
                    cnt2++;
                } else {
                    if(cnt1<N/2-1)
                        cnt1++;
                }
            }

            int sum1 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    sum1 += A[team1[i]][team1[j]];
                }
            }

            int sum2 = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    sum2 += A[team2[i]][team2[j]];
                }
            }

            if (Math.abs(sum1 - sum2) < min)
                min = Math.abs(sum1 - sum2);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                if (n > 0 && i <= team1[n - 1])
                    continue;
                isUsed[i] = true;
                team1[n] = i;
                func(n + 1);
                isUsed[i] = false;
            }
        }

    }
}

