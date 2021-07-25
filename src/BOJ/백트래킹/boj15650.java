package BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15650 {
    static int N, M;
    static int[] arr;
    static boolean[] isUsed;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isUsed = new boolean[N+1];
        func(0);

    }

    static void func(int m) {
        if (m == M) {
            for (int i = 0; i < M; i++)
                System.out.print(arr[i] + " ");
            System.out.println();

            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                if( m>0 && i<=arr[m-1])
                    continue;
                isUsed[i] = true;
                arr[m] = i;
                func(m + 1);
                isUsed[i] = false;
            }
        }

    }
}
