package BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10819 {
    static int N, M, max = 0;
    static int[] A, B;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = new int[N];
        isUsed = new boolean[N];
        func(0);
        System.out.println(max);

    }

    static void func(int n) {
        if (n == N) {

            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(B[i] - B[i + 1]);
            }

            if (sum > max)
                max = sum;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                B[n] = A[i];
                func(n + 1);
                isUsed[i] = false;
            }
        }

    }
}
