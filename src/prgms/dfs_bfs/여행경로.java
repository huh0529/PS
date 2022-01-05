package prgms.dfs_bfs;

import java.util.*;

class Solution4 {
    String[] answer = {};

    public String[] solution(String[][] tickets) {

        visited = new boolean[tickets.length];

        Arrays.sort(tickets, (o1, o2) -> {
            if(o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            } else {
                return o1[0].compareTo(o2[0]);
            }
        });

        list.add("ICN");
        dfs("ICN",tickets);

        return answer;
    }

    boolean[] visited;
    List<String> list = new ArrayList<>();

    void dfs(String start, String[][] tickets) {
        if(answer.length>0)
            return;

        if (list.size() == tickets.length+1) {
            answer = new String[list.size()];
            for(int i=0; i<list.size(); i++) {
                answer[i] = list.get(i);
            }
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(start) && !visited[i]) {
                visited[i]=true;
                list.add(tickets[i][1]);
                dfs(tickets[i][1], tickets);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}