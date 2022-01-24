package SWEA.분할정복;

import java.util.Scanner;

public class swea10507 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int n = sc.nextInt();
            int p = sc.nextInt();

            boolean[] day = new boolean[1000001];
            for (int i = 0; i < n; i++) {
                day[sc.nextInt()] = true;
            }

            int s = 0;
            int e = 0;
            int cnt = 0;
            int max = 0;

            while (e <= 1000000) {
                if (day[e]) {
                    e++;
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    if (p == 0) {
                        max = Math.max(max, cnt);
                        if (!day[s])
                            p++;
                        s++;
                        cnt--;
                    } else {
                        p--;
                        e++;
                        cnt++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + max);
        }
    }
}
