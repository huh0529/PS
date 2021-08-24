package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj16437 {
    static int N;
    static ArrayList<Integer>[] A;
    static char[] sw;
    static int[] m;

    static long postOrder(int v) {
        long total = 0;
        for (int i : A[v]) {
            total += postOrder(i);
        }

        if (sw[v] == 'S')
            return total + m[v];
        else
            return (total - m[v] >= 0) ? total - m[v] : 0;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new ArrayList[N + 1];
        sw = new char[N + 1];
        m = new int[N + 1];

        for (int i = 0; i <= N; i++)
            A[i] = new ArrayList<Integer>();

        for (int i = 2; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sw[i] = st.nextToken().charAt(0);
            m[i] = Integer.parseInt(st.nextToken());
            A[Integer.parseInt(st.nextToken())].add(i);
        }


        System.out.println(postOrder(1));
    }
}
