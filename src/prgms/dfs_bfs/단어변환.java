package prgms.dfs_bfs;

class Solution3 {
    boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        visited = new boolean[words.length];

        dfs(begin,target,words,0);

        if (min != Integer.MAX_VALUE) {
            answer = min;
        }
        return answer;
    }

    int min = Integer.MAX_VALUE;

    void dfs(String begin, String target, String[] words, int cnt) {

        if (begin.equals(target)) {
            if (cnt < min) {
                min=cnt;
            }
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if(visited[i])
                continue;

            int n=0;
            for (int j = 0; j < begin.length(); j++) {
                if (begin.charAt(j) != words[i].charAt(j)) {
                    n++;
                }
            }
            if (n == 1) {
                visited[i] = true;
                dfs(words[i], target, words, cnt+1);
                visited[i] = false;

            }
        }
    }
}