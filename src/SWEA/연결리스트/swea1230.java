package SWEA.연결리스트;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1230 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
//        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }

            int M = sc.nextInt();

            for (int i = 0; i < M; i++) {
                switch (sc.next().charAt(0)) {
                    case 'I':
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            list.add(x++, sc.nextInt());
                        }
                        break;
                    case 'D':
                        x = sc.nextInt();
                        y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            list.remove(x);
                        }
                        break;
                    case 'A':
                        y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            list.add(sc.nextInt());
                        }
                        break;
                }
            }

            System.out.printf("#%d",test_case);
            for (int i = 0; i < 10; i++) {
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        }
    }
}
