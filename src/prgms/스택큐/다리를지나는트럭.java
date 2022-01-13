package prgms.스택큐;

import java.util.LinkedList;
import java.util.Queue;

class Solution3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();

        int onBridge = 0;
        int total = 0;
        int truck = 0;


        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }

        while (truck < truck_weights.length) {
            answer++;

            int n = q.poll();

            if (n > 0) {
                onBridge--;
                total -= n;
            }


            if (onBridge < bridge_length && total + truck_weights[truck] <= weight) {
                q.add(truck_weights[truck]);
                total += truck_weights[truck];
                onBridge++;
                truck++;
            } else
                q.add(0);
        }

        return answer + bridge_length;
    }
}