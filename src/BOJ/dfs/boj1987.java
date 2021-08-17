package BOJ.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1987 {
    static int[][] A = new int[22][22];
    static boolean[] isUsed = new boolean[27];
    static boolean[][] visited = new boolean[22][22];
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int max = 0;

    static void dfs(int x, int y, int cnt){
        if(cnt > max)
            max = cnt;

        for(int i=0;i<4;i++) {
            if(!visited[x + dx[i]][y + dy[i]] && !isUsed[A[x + dx[i]][y + dy[i]]]){
                visited[x + dx[i]][y + dy[i]] = true;
                isUsed[A[x + dx[i]][y + dy[i]]] = true;

                dfs(x+dx[i],y+dy[i], cnt+1);

                visited[x + dx[i]][y + dy[i]] = false;
                isUsed[A[x + dx[i]][y + dy[i]]] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= R; i++) {
            String str = br.readLine();
            for (int j = 1; j <= C; j++) {
                A[i][j] = (str.charAt(j-1) - 'A') + 1;
            }
        }

        isUsed[0]=true;
        isUsed[A[1][1]] = true;
        visited[1][1] = true;
        dfs(1,1, 1);

        System.out.println(max);
    }
}
