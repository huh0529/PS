package SWEA.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1233 {
    static int N;
    static char[] c;
    static int flag;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.


            N = Integer.parseInt(br.readLine());
            c = new char[N + 1];
            flag = 1;

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                c[Integer.parseInt(st.nextToken())] = st.nextToken().charAt(0);
            }

            inorder(1);
            System.out.println("#" + test_case + " " + flag);
        }
    }

    static void inorder(int k) {
        if (k * 2 <= N) {
            inorder(k * 2);
        } else {
            if (c[k] == '+' || c[k] == '-' || c[k] == '*' || c[k] == '/') {
                flag = 0;
                return;
            }
        }

        if (k * 2 + 1 <= N) {
            inorder(k * 2 + 1);
        } else {
            if (c[k] == '+' || c[k] == '-' || c[k] == '*' || c[k] == '/') {
                flag = 0;
            }
        }
    }
}
