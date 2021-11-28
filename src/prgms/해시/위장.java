package prgms.해시;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();

        for (String[] c :clothes) {
            if (map.containsKey(c[1])) {
                map.put(c[1], map.get(c[1]) + 1);
            } else {
                map.put(c[1], 2);
            }
        }


        for (String key : map.keySet()) {
            answer *= map.get(key);
        }

        return answer - 1;
    }
}