package SWEA.연결리스트;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea13501 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();

            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                list.add(sc.nextInt());
            }

            for (int i = 0; i < M; i++) {
                switch (sc.next().charAt(0)) {
                    case 'I':
                        list.add(sc.nextInt(), sc.nextInt());
                        break;
                    case 'D':
                        list.remove(sc.nextInt());
                        break;
                    case 'C':
                        int index = sc.nextInt();
                        list.remove(index);
                        list.add(index, sc.nextInt());
                        break;
                }
            }

            if (list.size() <= L) {
                System.out.printf("#%d -1", test_case);
            } else {
                System.out.printf("#%d %d", test_case, list.get(L));
            }
            System.out.println();
        }
    }
}
