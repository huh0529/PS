package BOJ.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1629 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(func(A, B, C) % C);
    }

    static long func(int A, int B, int C) {

        if (B == 1)
            return A;

        long x = func(A, B / 2, C) % C;

        if (B % 2 == 0) {
            return ((x * x) % C);
        } else {
            return (((x * x) % C) * A) % C;
        }
    }
}
