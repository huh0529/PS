package SWEA.분할정복;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class swea7701 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int N = sc.nextInt();

            TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int r = o1.length() - o2.length();
                    if (r == 0)
                        return o1.compareTo(o2);
                    else
                        return r;
                }
            });

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                set.add(sc.next());
            }

            for (String str : set) {
                System.out.println(str);
            }
        }
    }
}
