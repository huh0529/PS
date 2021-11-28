package prgms.해시;


import java.util.Map;
import java.util.TreeMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;



        for (String a : phone_book) {
            for (String b : phone_book) {
                if (a.equals(b) || a.length() <= b.length())
                    continue;
                if (a.startsWith(b)) {
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}