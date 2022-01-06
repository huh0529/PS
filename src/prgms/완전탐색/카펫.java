package prgms.완전탐색;

class Solution3 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int x = i;
                int y = yellow / i;

                if ((x + y) * 2 + 4 == brown) {
                    answer[0] = y + 2;
                    answer[1] = x + 2;
                    break;
                }
            }
        }
        return answer;
    }
}