package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1072 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        double X = Integer.parseInt(st.nextToken());
        double Y = Integer.parseInt(st.nextToken());
        int Z = (int) (100 * Y / X);

        if (Z == 100 || Z == 99) {
            System.out.println(-1);
            return;
        }
        int n;
        n = (int) Math.ceil(((1 + Z) * X - 100 * Y) / (99 - Z));
        System.out.println(n);
    }
}
