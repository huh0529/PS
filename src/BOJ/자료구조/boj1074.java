package BOJ.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1074 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(func(N, r, c));
    }

    static int func(int N, int r, int c) {
        int mid = (int) Math.pow(2, N - 1);

        if(N==0)
            return 0;

        if (r < mid && c < mid)
            return func(N - 1, r, c);
        if (r < mid && c >= mid)
            return mid*mid + func(N-1, r, c-mid);
        if (r >= mid && c < mid)
            return 2*mid*mid +func(N-1, r-mid, c);
        if (r >= mid && c >= mid)
            return 3*mid*mid +func(N-1, r-mid, c-mid);

        return 0;
    }
}
