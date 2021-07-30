package BOJ.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj14002 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (A[j] > A[i])
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
            }
            if (dp[i] > max) {
                max = dp[i];
                index = i;
            }
        }

        System.out.println(max + 1);

//        for (int i = 0; i < N; i++)
//            System.out.print(dp[i] + " ");
//        System.out.println();

        Stack<Integer> stack = new Stack<>();

        stack.push(A[index]);
        max--;
        int len = index;
        for (int i = len - 1; i >= 0; i--) {
            if (dp[i] == max && A[i] < A[index]) {
                stack.push(A[i]);
                max--;
                index = i;
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}