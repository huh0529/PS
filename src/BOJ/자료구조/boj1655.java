package BOJ.자료구조;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class boj1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int e = Integer.parseInt(br.readLine());

            if (maxQ.size() == minQ.size())
                maxQ.add(e);
            else
                minQ.add(e);

            if (!minQ.isEmpty() && (maxQ.peek() > minQ.peek())) {
                minQ.add(maxQ.poll());
                maxQ.add(minQ.poll());
            }
            sb.append(maxQ.peek() + "\n");
        }
        System.out.println(sb);
    }
}