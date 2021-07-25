package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N + 1];


        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0)
                if (i % 3 == 0)
                    A[i] = Math.min(A[i - 1], Math.min(A[i / 2], A[i / 3])) + 1;
                else
                    A[i] = Math.min(A[i - 1], A[i / 2]) + 1;

            else if (i % 3 == 0)
                A[i] = Math.min(A[i - 1], A[i / 3]) + 1;

            else
                A[i] = A[i - 1] + 1;
        }

        System.out.println(A[N]);
    }
}
