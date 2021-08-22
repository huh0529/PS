package BOJ.bfs;

import java.util.*;
import java.io.*;

public class boj16236 {
    static int N;
    static int[][] A = new int[20][20];
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == 9) {
                    A[i][j] = 0;
                    x = i;
                    y = j;
                }
            }
        }

        int total = 0;
        int eat = 0;
        int size = 2;
        boolean flag;

        do {
            flag = false;
            visited = new boolean[N][N];
            Node node = bfs(x, y, size);
            if (x == node.x && y == node.y) {
                break;
            }
            x = node.x;
            y = node.y;
            A[x][y] = 0;

            eat++;
            if (eat == size) {
                size++;
                eat = 0;
            }
            total += node.len;

            System.out.println(x + " " + y + " total=" + total + " size=" + size);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(A[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("====================");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (A[i][j] < size && A[i][j] > 0)
                        flag = true;
                }
            }
        } while (flag);

        System.out.println(total);
    }

    static Node bfs(int i, int j, int size) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(i, j, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int k = 0; k < 4; k++) {
                int x = node.x + dx[k];
                int y = node.y + dy[k];
                int len = node.len;

                if (x < 0 || x >= N || y < 0 || y >= N)
                    continue;

                if (!visited[x][y]) {
                    if (A[x][y] == size || A[x][y] == 0) {
                        visited[x][y] = true;
                        q.add(new Node(x, y, len + 1));
                    } else if (A[x][y] < size) {
                        return new Node(x, y, len + 1);
                    }
                }

            }
        }
        return new Node(i, j, 0);
    }
}

class Node {
    int x;
    int y;
    int len;

    Node(int x, int y, int len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }
}