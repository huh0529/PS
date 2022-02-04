package SWEA.해시;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class swea2948 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.


            int n = sc.nextInt();
            int m = sc.nextInt();
            int answer = 0;

            Set<String> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                String str = sc.next();
                set.add(str);
            }

            for (int i = 0; i < m; i++) {
                String str = sc.next();
                if (set.contains(str)) {
                    answer++;
                }
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}
