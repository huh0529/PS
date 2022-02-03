package SWEA.트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea1232 {
    private static int N;
    private static Node[] tree;
    private static int answer;

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T;
        T = 10;

        for (int test_case = 1; test_case <= T; test_case++) {
            //이 부분에 여러분의 알고리즘 구현이 들어갑니다.


            N = Integer.parseInt(br.readLine());
            answer = 0;
            tree = new Node[N+1];
            for (int i = 0; i <= N; i++) {
                tree[i] = new Node();
            }

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                tree[parent].e = st.nextToken();

                if (st.hasMoreTokens()) {
                    tree[parent].left = tree[Integer.parseInt(st.nextToken())];
                    tree[parent].right = tree[Integer.parseInt(st.nextToken())];
                }
            }

            answer = (int) postorder(tree[1]);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    static double postorder(Node node) {
        if (node.left == null && node.right == null) {
            return Integer.parseInt(node.e);
        }

        double a = postorder(node.left);
        double b = postorder(node.right);

        switch (node.e.charAt(0)) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }

    }

    static class Node {
        String e;
        Node left;
        Node right;
    }
}
