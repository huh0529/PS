package BOJ.구간합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj1644 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (a[i] == 0) {
                list.add(i);
                int j = i * 2;
                while (j <= n) {
                    a[j] = 1;
                    j += i;
                }
            }
        }

        ArrayList<Integer> sum = new ArrayList<>();
        sum.add(0);

        int x = 0;
        for (int i : list) {
            x += i;
            sum.add(x);
        }

        int cnt = 0;
        int i = 0;
        int j = 0;

        while (i < sum.size() && j < sum.size()) {
            if (sum.get(j) - sum.get(i) == n) {
                cnt++;
                i++;
            } else if (sum.get(j) - sum.get(i) < n) {
                j++;
            } else if (sum.get(j) - sum.get(i) > n) {
                i++;
            }
        }

        System.out.println(cnt);
    }
}
