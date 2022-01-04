package prgms.dfs_bfs;

class Solution1 {
    int cnt=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;

        dfs(numbers,target,0,0);
        answer = cnt;


        return answer;
    }

    public void dfs(int[] numbers, int target, int n, int sum) {
        if (n == numbers.length-1) {
            if (sum + numbers[n] == target || sum - numbers[n] == target) {
              cnt++;
            }
            return;
        }

        dfs(numbers, target, n+1, sum+numbers[n]);

        dfs(numbers, target, n+1, sum-numbers[n]);
    }
}
