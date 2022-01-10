package prgms.스택큐;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        int t = 0;

        while (priorities[location] != 0) {
            while (priorities[t] == 0) {
                t = (t + 1) % priorities.length;
            }

            if (priorities[t] == pq.peek()) {
                pq.remove();
                priorities[t] = 0;
                answer++;
            } else {
                t = (t + 1) % priorities.length;
            }
        }
        return answer;
    }
}