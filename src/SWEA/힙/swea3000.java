package SWEA.힙;

import java.util.*;

public class swea3000 {
//    private static List<Integer> list;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQ = new PriorityQueue<>();
            long sum = 0;

            int n = sc.nextInt();
            maxQ.add(sc.nextInt());

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    int k = sc.nextInt();

                    if (k > maxQ.peek()) {
                        minQ.add(k);
                    } else
                        maxQ.add(k);
                }

                while (maxQ.size() > minQ.size() + 1) {
                    minQ.add(maxQ.remove());
                }
                while (maxQ.size() <= minQ.size() ) {
                    maxQ.add(minQ.remove());
                }

                sum = (sum + maxQ.peek()) % 20171109;
            }

            System.out.printf("#%d %d\n", test_case, sum);



//            이분탐색 -> 10개중 6솔 (시간초과)
//            list = new ArrayList<>();
//            list.add(sc.nextInt());
//
//            long sum = 0;
//            for (int i = 1; i <= n; i++) {
//                for (int j = 0; j < 2; j++) {
//                    binary(sc.nextInt());
//                }
//                sum = (sum + list.get(i)) % 20171109;
//            }
//
//            System.out.printf("#%d %d\n", test_case, sum);
        }
    }

//    private static void binary(int k) {
//        int l = 0;
//        int r = list.size() - 1;
//
//        while (l <= r) {
//            int m = (l + r) / 2;
//
//            if (list.get(m) == k) {
//                list.add(m, k);
//                return;
//            } else if (list.get(m) > k) {
//                r = m - 1;
//            } else if (list.get(m) < k) {
//                l = m + 1;
//            }
//        }
//
//        list.add(l, k);
//    }
}
