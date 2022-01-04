package prgms.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n; i++) {

            if (!visited[i])
                answer++;
            else
                continue;

            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while (!q.isEmpty()) {
                int x = q.poll();

                if (visited[x]) {
                    continue;
                } else {
                    visited[x] = true;
                }

                for (int j = 0; j < n; j++) {
                    if (j == x)
                        continue;

                    if (!visited[j] && computers[x][j] == 1) {
                        q.add(j);
                    }
                }
            }
        }

        return answer;
    }
}