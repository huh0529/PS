package BOJ.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2021 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] stations = new ArrayList[N + 1];
        ArrayList<Integer>[] lines = new ArrayList[L + 1];
        boolean[] visitedLine = new boolean[L + 1];

        for (int i = 1; i <= N; i++) {
            stations[i] = new ArrayList<>();
        }

        for (int i = 1; i <= L; i++) {
            lines[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());

            while (e != -1) {
                stations[e].add(i);
                lines[i].add(e);
                e = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<S> q = new LinkedList<>();
        q.add(new S(start, 0));

        while (!q.isEmpty()) {
            S s = q.poll();

            for (int line : stations[s.cur]) {
                if(visitedLine[line])
                    continue;
                else
                    visitedLine[line] = true;

                for (int station : lines[line]) {
                    if (station == end) {
                        System.out.println(s.len);
                        System.exit(0);
                    }

                    q.add(new S(station, s.len + 1));
                }
            }
        }
        System.out.println(-1);
    }
}

class S {
    int cur;
    int len;

    S(int cur, int len) {
        this.cur = cur;
        this.len = len;
    }
}