package BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj15651 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        func(0);
        System.out.println(sb);

    }

    static void func(int m) {
        if (m == M) {
            for (int i = 0; i < M; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[m] = i;
            func(m + 1);
        }
    }
}
