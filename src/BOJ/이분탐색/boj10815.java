package BOJ.이분탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj10815 {
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int L = 0;
            int R = N - 1;
            int mid;
            int k = Integer.parseInt(st.nextToken());

            int flag = 0;
            while (L <= R) {
                mid = (R + L) / 2;

                if (k == A[L] || k == A[mid]) {
                    flag = 1;
                    break;
                }

                if (k < A[mid])
                    R = mid - 1;
                if (k > A[mid])
                    L = mid + 1;
            }

            if (flag == 1)
                System.out.print("1 ");
            else
                System.out.print("0 ");
        }
    }
}
