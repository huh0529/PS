package SWEA.그리디;

import java.util.Scanner;

public class swea1970 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = sc.nextInt();

            int[][] coin = {{50000, 0}, {10000, 0}, {5000, 0}, {1000, 0}, {500, 0}, {100, 0}, {50, 0}, {10, 0}};

            for (int i = 0; i < 8; i++) {
                coin[i][1] = N / coin[i][0];
                N -= coin[i][0] * coin[i][1];
            }
            System.out.println("#"+test_case);
            for (int i = 0; i < 8; i++) {
                System.out.print(coin[i][1] + " ");
            }
            System.out.println();
        }
    }
}