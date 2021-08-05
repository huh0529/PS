package BOJ.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1269 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());


        int[] A = new int[a];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] B = new int[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int sum = a + b;
        int p = 0;
        for (int i = 0; i < a; i++) {
            while (p < b) {
                if (A[i] == B[p]) {
                    sum--;
                    p++;
                    break;
                }

                if (A[i] > B[p]) {
                    p++;
                    continue;
                }

                if (A[i] < B[p])
                    break;
            }
        }


        p = 0;
        for (int i = 0; i < b; i++) {
            while (p < a) {
                if (B[i] == A[p]) {
                    sum--;
                    p++;
                    break;
                }

                if (B[i] > A[p]) {
                    p++;
                    continue;
                }

                if (B[i] < A[p])
                    break;
            }
        }

        System.out.println(sum);
    }
}
