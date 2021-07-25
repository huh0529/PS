package BOJ.구간합;

import java.io.*;
import java.util.*;

public class boj11441 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A= new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1;i<=N;i++){
            A[i]=Integer.parseInt(st.nextToken());
            A[i]+=A[i-1];
        }

        int M = Integer.parseInt(br.readLine());

        for(int m=0;m<M;m++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(A[j]-A[i-1]);
        }
    }
}