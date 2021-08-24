package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj16437 {
    static int N;
    static int[][] A;
    static int cnt;

    static void dfs(int cur, int next) {
        if (A[cur][0] == 0) {
            dfs(next, A[next][2]);
        } else {
            cnt += A[cur][1];
            A[cur][1] = 0;

            if (next == 1)
                return;

            if (A[next][0] == 0) {
                if (A[next][1] > cnt) {
                    A[next][1] -= cnt;
                    cnt = 0;
                } else {
                    cnt -= A[next][1];
                    A[next][1] = 0;
                }
            } else {
                cnt += A[next][1];
                A[next][1] = 0;
            }

            dfs(next, A[next][2]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N + 1][4];

        Queue<Integer> q = new LinkedList<>();

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("W"))
                A[i][0] = 0;
            else
                A[i][0] = 1;
            A[i][1] = Integer.parseInt(st.nextToken());
            A[i][2] = Integer.parseInt(st.nextToken());
            A[A[i][2]][3]=i;
        }

        for (int i = 2; i <= N; i++) {
            if(A[i][3]==0) {
                q.add(i);
            }
        }

        int total = 0;

        while(!q.isEmpty()){
            int i = q.poll();
            if (A[i][0] == 1) {
                cnt = 0;
                dfs(i, A[i][2]);
                total += cnt;
            }
        }

        System.out.println(total);
    }
}
