class Solution {
    int ans = 1;

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        int[][] visited;

        for (int t = 0; t < 5; t++) {
            ans=1;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[t][i].charAt(j) == 'P') {
                        visited = new int[5][5];
                        dfs(places, visited, t, i, j, 2);
                    }
                    if(ans==0)
                        break;
                }
                if(ans==0)
                    break;
            }
            answer[t]=ans;
        }
        return answer;
    }

    public void dfs(String[][] places, int[][] visited, int t, int x, int y, int n) {
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        visited[x][y]=1;

        if (places[t][x].charAt(y) == 'O') {
            if (n == 0)
                return;
        }
        if (places[t][x].charAt(y) == 'X')
            return;

        if (places[t][x].charAt(y) == 'P' && n<2) {
            ans = 0;
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (x + dx[i] < 0 || x + dx[i] >= 5 || y + dy[i] < 0 || y + dy[i] >= 5)
                continue;

            if(visited[x+dx[i]][y+dy[i]]==0)
                dfs(places, visited, t, x + dx[i], y + dy[i], n - 1);
        }
    }
}