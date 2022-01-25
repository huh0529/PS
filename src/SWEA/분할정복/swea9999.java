package SWEA.분할정복;

import java.util.Scanner;

public class swea9999 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int L = sc.nextInt();
            int N = sc.nextInt();

            boolean[] arr = new boolean[100000000];

            int s = 0;
            int e = 0;

            for (int i = 0; i < N; i++) {
                s = sc.nextInt();
                e = sc.nextInt();

                for (int j = s+1; j <= e; j++) {
                    arr[j] = true;
                }
            }

            int sum = 0;
            s = 0;
            int max = 0;

            for (int i = 0; i < L; i++) {
                if(arr[i])
                    sum++;
            }

            for(int i = L; i < e; i++) {
                if (arr[i]) {
                    sum++;
                }
                if (arr[s++]) {
                    sum--;
                }

                max = Math.max(max, sum);
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
