package prgms.그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution2 {
    public int solution(int n, int[][] results) {
        int answer = 0;

        List<Integer>[][] lists = new List[n][2];
        for (int i = 0; i < n; i++) {
            lists[i][0] = new ArrayList<>();
            lists[i][1] = new ArrayList<>();
        }

        for (int[] result : results) {
            int v1 = result[0] - 1;
            int v2 = result[1] - 1;

            lists[v1][1].add(v2);
            lists[v2][0].add(v1);
        }


        for (int i = 0; i < n; i++) {

            boolean[] visited = new boolean[n];

            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            int cnt = -1;
            while (!q.isEmpty()) {
                cnt++;
                int k = q.poll();

                for (int j = 0; j < lists[k][0].size(); j++) {
                    if (!visited[lists[k][0].get(j)]) {
                        visited[lists[k][0].get(j)] = true;
                        q.add(lists[k][0].get(j));
                    }
                }
            }

            visited = new boolean[n];
            q.add(i);
            while (!q.isEmpty()) {
                cnt++;
                int k = q.poll();
                for (int j = 0; j < lists[k][1].size(); j++) {
                    if (!visited[lists[k][1].get(j)]) {
                        visited[lists[k][1].get(j)] = true;
                        q.add(lists[k][1].get(j));
                    }
                }
            }

            if (cnt == n)
                answer++;
        }

        return answer;
    }
}