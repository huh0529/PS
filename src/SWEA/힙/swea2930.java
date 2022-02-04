package SWEA.힙;

import java.util.*;

public class swea2930 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
            List<Integer> list = new ArrayList<>();

            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int cmd = sc.nextInt();

                if (cmd == 1) {
                    q.add(sc.nextInt());
                } else {
                    if (q.isEmpty())
                        list.add(-1);
                    else
                        list.add(q.remove());
                }
            }

            System.out.print("#" + test_case);
            for (int k : list) {
                System.out.print(" " + k);
            }
            System.out.println();
        }
    }
}
