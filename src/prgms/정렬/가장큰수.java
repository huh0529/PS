package prgms.정렬;

import java.util.Arrays;
import java.util.Comparator;

class Solution2 {
    public String solution(int[] numbers) {
        String answer = "";

        String[] s = Arrays.toString(numbers).split("[\\[\\]]")[1].split(", ");
        Arrays.sort(s, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {

                return ((o2 + o1).compareTo(o1 + o2));
            }
        });

        if(s[0].equals("0")) {
            return "0";
        }

        for (String str :s) {
            answer += str;
        }

        return answer;
    }
}
