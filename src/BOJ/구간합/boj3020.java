package BOJ.구간합;
import java.io.*;
import java.util.*;

public class boj3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] top = new int[500001];
        int[] bottom = new int[500001];

        int min = 500000;
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0)
                bottom[Integer.parseInt(br.readLine())]++;
            else
                top[Integer.parseInt(br.readLine())]++;
        }

        for (int i = H; i >1; i--) {
            bottom[i-1] += bottom[i];
            top[i-1] += top[i];
        }

        for (int i = 1;i<=H;i++) {
            bottom[i]+=top[H-i+1];
        }

        for (int i = 1;i<=H;i++) {
            if(bottom[i]<min)
                min=bottom[i];
        }

        for (int i = 1;i<=H;i++) {
            if(bottom[i]==min)
                cnt++;
        }
        System.out.println(min + " " + cnt);
    }
}