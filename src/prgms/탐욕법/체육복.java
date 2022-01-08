package prgms.탐욕법;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] st = new int[n + 2];

        for (int i = 0; i < lost.length; i++) {
            st[lost[i]]--;
        }

        for (int i = 0; i < reserve.length; i++) {
            st[reserve[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (st[i] == -1) {
                if (st[i - 1] == 1) {
                    st[i - 1] = 0;
                    st[i] = 0;
                } else if (st[i + 1] == 1) {
                    st[i + 1] = 0;
                    st[i] = 0;
                }
            }

            if (st[i] == 0 || st[i] == 1) {
                answer++;
            }
        }

        return answer;
    }
}
