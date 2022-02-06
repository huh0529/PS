package SWEA.그래프탐색;

import java.util.*;

//LCA 다시 제대로 공부
public class swea1855 {
    static int N;
    static int[][] parent;
    static int[] depth;
    static List<List<Integer>> lists;
    static List<Integer> search;
    static Queue<Integer> q;
    static long answer;

    private static void bfs() {
        q.add(1);

        while (!q.isEmpty()) {
            int k = q.poll();

            for (int idx : lists.get(k)) {
                q.add(idx);
                search.add(idx);
                depth[idx] = depth[k] + 1;
            }
        }
    }

    private static void setParent() {
        for (int i = 1; i < 20; i++) {
            for (int n = 1; n <= N; n++) {
                int halfParent = parent[n][i - 1];
                parent[n][i] = parent[halfParent][i - 1];
            }
        }
    }

    private static int LCA(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        // 더 깊은 노드를 부모노드로 초기화하면서 깊이를 통일함.
        for (int i = 19; i >= 0; i--) {
            long difference = depth[a] - depth[b];
            if (difference >= (1 << i)) {
                a = parent[a][i];
            }
        }

        // 깊이를 맞추었을 때 두 노드가 같으면 공통 부모임.
        if (a == b) {
            return a;
        }

        // 2^i를 큰 수부터 줄여가면서 조상노드를 조회
        // 조상노드끼리 다르다면 해당 조상노드로 갱신
        for (int i = 19; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        // 반복이 끝났으면 공통된 조상노드 직전까지 온 상태

        return parent[a][0];
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            N = sc.nextInt();
            parent = new int[N + 1][20];
            depth = new int[N + 1];

            lists = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                lists.add(new ArrayList<Integer>());
            }

            for (int i = 2; i <= N; i++) {
                int p = sc.nextInt();
                parent[i][0] = p;
                lists.get(p).add(i);
            }


            depth[1] = 0;
            q = new LinkedList<>();
            search = new ArrayList<>();
            search.add(1);
            bfs();
            setParent();


            answer = 0;
            for (int i = 1; i < N; i++) {
                int L = LCA(search.get(i), search.get(i - 1));
                answer += (depth[search.get(i)] - depth[L]) + (depth[search.get(i - 1)] - depth[L]);
            }

            System.out.printf("#%d %d\n", test_case, answer);
        }
    }
}
