package SWEA.비트연산;

import java.util.Scanner;

public class swea1288 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = sc.nextInt();
            int CN = 0;
            int check = 0;

            while (check != (1 << 10) - 1) {
                CN += N;

                int tmp = CN;

                while (tmp > 0) {
                    check |= 1 << (tmp % 10);
                    tmp /= 10;
                }
            }

            System.out.printf("#%d %d\n", test_case, CN);
        }
    }
}