package SWEA.트리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class swea1248 {
    private static Node[] nodes;
    private static int size;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.

            int V = sc.nextInt();
            int E = sc.nextInt();
            int s = sc.nextInt();
            int e = sc.nextInt();

            nodes = new Node[V + 1];
            for (int i = 0; i < V + 1; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < E; i++) {
                Node parent = nodes[sc.nextInt()];
                Node child = nodes[sc.nextInt()];

                child.parent = parent;
                if (parent.left == null) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
            }

            nodes[1].parent = nodes[0];
            List<Integer> list = new ArrayList<>();
            while (s >= 1) {
                list.add(s);
                s = nodes[s].parent.e;
            }

            int idx = 0;
            while (e >= 1) {
                for (int k : list) {
                    if (k == e) {
                        idx = k;
                        e = 1;
                        break;
                    }
                }

                e = nodes[e].parent.e;
            }

            size = 0;
            getSize(nodes[idx]);
            System.out.printf("#%d %d %d\n", test_case, idx, size);
        }
    }

    static void getSize(Node node) {
        size++;
        if (node.left != null) {
            getSize(node.left);
        }
        if (node.right != null) {
            getSize(node.right);
        }
    }

    static class Node {
        int e;
        Node parent, left, right;

        public Node(int e) {
            this.e = e;
        }
    }
}