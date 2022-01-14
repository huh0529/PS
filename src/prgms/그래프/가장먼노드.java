package prgms.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    List<Integer>[] vLists;
    boolean[] visited;
    int[] dist;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        vLists = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            vLists[i] = new ArrayList<>();
        }
        visited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int[] e : edge) {
            int v1 = e[0];
            int v2 = e[1];

            vLists[v1].add(v2);
            vLists[v2].add(v1);
        }

        visited[1] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while (!q.isEmpty()) {
            int v = q.poll();

            for (int i = 0; i < vLists[v].size(); i++) {
                if (!visited[vLists[v].get(i)]) {
                    visited[vLists[v].get(i)] = true;
                    dist[vLists[v].get(i)] = dist[v] + 1;
                    q.add(vLists[v].get(i));
                }
            }
        }

        int cnt = 0;
        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            if (dist[i] == max) {
                cnt++;
            } else if (dist[i] > max) {
                cnt = 1;
                max = dist[i];
            }
        }

        answer = cnt;
        return answer;
    }
}