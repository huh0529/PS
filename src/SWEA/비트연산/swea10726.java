package SWEA.비트연산;

import java.util.Scanner;

public class swea10726 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = sc.nextInt();
            int M = sc.nextInt();

            if ((M & (1<<N)-1) == (1<<N)-1){
                System.out.println("#" + test_case + " ON");
            } else
                System.out.println("#" + test_case + " OFF");
        }
    }
}