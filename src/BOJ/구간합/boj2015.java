package BOJ.구간합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj2015 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N+1];
        int[] sum = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
            sum[n]=sum[n-1]+A[n];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        int cnt=0;

        for(int i=1;i<=N;i++){
            cnt += map.getOrDefault(sum[i] - K, 0);
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }

        System.out.println(cnt);
    }
}
