package prgms.스택큐;

import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public List<Integer> solution(int[] progresses, int[] speeds) {

        List<Integer> answer = new ArrayList<>();

        int t = 0;

        while (t < progresses.length) {
            int cnt=0;

            for (int i = t; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }

            for (int i = t; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    t++;
                    cnt++;
                } else {
                    break;
                }
            }
            if(cnt>0) {
                answer.add(cnt);
            }
        }

        return answer;
    }
}
