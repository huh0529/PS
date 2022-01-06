package prgms.완전탐색;

import java.util.HashSet;
import java.util.Set;

class Solution2 {
    public int solution(String numbers) {
        int answer = 0;

        int[] num = new int[numbers.length()];
        visited = new boolean[numbers.length()];

        for (int i = 0; i < numbers.length(); i++) {
            num[i] = numbers.charAt(i) - '0';
        }

        isPrime(10000000);

        for (int i = 1; i <= num.length; i++) {
            func(num, i, 0);
        }

        answer = list.size();

        return answer;
    }

    boolean[] visited;
    Set<Integer> list = new HashSet<>();
    int x = 0;
    boolean[] prime = new boolean[10000000];

    void func(int[] num, int n, int now) {
        if (now == n) {
            if (!prime[x])
                list.add(x);
            return;
        }

        for (int i = 0; i < num.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                x = x * 10 + num[i];
                func(num, n, now + 1);
                x /= 10;
                visited[i] = false;
            }
        }
    }

    void isPrime(int n) {

        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                for (int j = i * 2; j < n; j+=i) {
                    prime[j] = true;
                }
            }
        }

    }
}