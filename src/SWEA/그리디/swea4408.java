package SWEA.그리디;

import java.util.Arrays;
import java.util.Scanner;

public class swea4408 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int[] room = new int[401];

            int N = sc.nextInt();

            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                if (x > y) {
                    int tmp = x;
                    x = y;
                    y = tmp;
                }

                if (x % 2 == 0)
                    x--;
                if (y % 2 == 1)
                    y++;

                for (int j = x; j <= y; j++) {
                    room[j]++;
                }

            }
            int max = Arrays.stream(room).max().getAsInt();

            System.out.println("#" + test_case + " " + max);
        }
    }
}
