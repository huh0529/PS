package SWEA.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1231 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = Integer.parseInt(br.readLine());
            char[] c = new char[N + 1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                c[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
            }

            System.out.print("#" + test_case + " ");
            inorder(c, 1, N);
            System.out.println();
        }
    }

    static void inorder(char[] c, int k, int N) {
        if (k * 2 <= N) {
            inorder(c, k * 2, N);
        }

        System.out.print(c[k]);

        if (k * 2 + 1 <= N) {
            inorder(c, k * 2 + 1, N);
        }
    }
}
