package SWEA;

import java.util.Scanner;

public class swea3304 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            String a = sc.next();
            String b = sc.next();
            int[][] L = new int[a.length() + 1][b.length() + 1];

            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        L[i][j] = L[i - 1][j - 1] + 1;
                    } else {
                        L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
                    }
                }
            }

            System.out.println("#"+test_case+" "+L[a.length()][b.length()]);
        }
    }
}
