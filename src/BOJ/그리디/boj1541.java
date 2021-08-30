package BOJ.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj1541 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] a = br.readLine().split("-");

        int total = 0;
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length(); j++) {
                String[] b = a[i].split("\\+");
                sum = 0;
                for (int k = 0; k < b.length; k++) {
                    int x = Integer.parseInt(b[k]);
                    sum += x;
                }
            }
            if (i == 0) {
                total += sum;
            } else {
                total -= sum;
            }
        }
        System.out.println(total);
    }
}
