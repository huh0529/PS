package BOJ.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj2661 {
    static int N;
    static char[] S;
    static String ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        S = new char[N];
        func(0);
    }

    static void func(int k) {
        if (k == N) {
            ans = String.valueOf(S);

            if (check(ans, N)) {
                System.out.println(ans);
                System.exit(0);
            }

        }
        for (int i = 1; i <= 3; i++) {
            S[k] = (char) (i + '0');
            ans = String.valueOf(S);
            if (check(ans, k + 1))
                func(k + 1);
        }
    }

    static boolean check(String str, int len) {
        for (int i = 1; i <= len / 2; i++) {
            if (str.substring(len - i, len).equals(str.substring(len - i * 2, len - i))) {
                return false;
            }
        }

        return true;
    }
}
