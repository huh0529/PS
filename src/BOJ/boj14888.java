package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14888 {
    static int N, min = 1000000000, max = -1000000000;
    static int[] A = new int[11];
    static int[] B = new int[4];
    static int[] cmd = new int[10];
    static int[] arr = new int[10];
    static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B[0] = Integer.parseInt(st.nextToken());
        for (int i = 0; i < B[0]; i++) {
            cmd[i] = 0;
        }

        B[1] = Integer.parseInt(st.nextToken());
        for (int i = B[0]; i < B[0] + B[1]; i++) {
            cmd[i] = 1;
        }

        B[2] = Integer.parseInt(st.nextToken());
        for (int i = B[0] + B[1]; i < B[0] + B[1] + B[2]; i++) {
            cmd[i] = 2;
        }

        B[3] = Integer.parseInt(st.nextToken());
        for (int i = B[0] + B[1] + B[2]; i < B[0] + B[1] + B[2] + B[3]; i++) {
            cmd[i] = 3;
        }

        func(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void func(int k) {
        if (k == N - 1) {
            int result = A[0];

            for (int i = 0; i < N - 1; i++) {
                System.out.print(arr[i]);
                switch (arr[i]) {
                    case 0:
                        result += A[i + 1];
                        break;
                    case 1:
                        result -= A[i + 1];
                        break;
                    case 2:
                        result *= A[i + 1];
                        break;
                    case 3:
                        result /= A[i + 1];
                        break;
                }
            }

            if (result > max)
                max = result;

            if (result < min)
                min = result;
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                arr[k] = cmd[i];
                func(k + 1);
                isUsed[i] = false;
            }
        }

    }

}