package prgms;

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int[] arr = new int[1000];
        Stack<Integer> Zstack = new Stack<>(); //int형 스택 선언
        ArrayList<Integer> list = new ArrayList<>();

        int last = n - 1;
        int x=0;

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for (int i = 0; i < cmd.length; i++) {
            switch (cmd[i].charAt(0)) {
                case 'U':
                    x = Integer.parseInt(cmd[i].replaceAll("[^0-9]", ""));
                    while (x>0) {
                        k--;
                        if (arr[k] == 1)
                            continue;
                        x--;
                    }
                    break;
                case 'D':
                    x = Integer.parseInt(cmd[i].replaceAll("[^0-9]", ""));
                    while (x>0) {
                        k++;
                        if (arr[k] == 1)
                            continue;
                        x--;
                    }
                    break;
                case 'C':
                    arr[k] = 1;

                    Zstack.push(k);

                    if (k == last) {
                        k--;
                        while (arr[k] == 1)
                            k--;
                        last = k;
                    }
                    else {
                        k++;
                        while (arr[k] == 1)
                            k++;
                    }
                    break;
                case 'Z':
                    arr[Zstack.pop()] = 0;
                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                answer += 'O';
            else
                answer += 'X';
        }

        return answer;
    }
}