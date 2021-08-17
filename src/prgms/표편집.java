package prgms;

import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int[] arr = new int[1000];
        Stack<Integer> Zstack = new Stack<>(); //int형 스택 선언
        ArrayList<Integer> list = new ArrayList<>();
        int last = n - 1;
        int x = 0;

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for (int i = 0; i < cmd.length; i++) {
            switch (cmd[i].charAt(0)) {
                case 'U':
                    x = Integer.parseInt(cmd[i].replaceAll("[^0-9]", ""));
                    k -= x;
                    break;
                case 'D':
                    x = Integer.parseInt(cmd[i].replaceAll("[^0-9]", ""));
                    k += x;
                    break;
                case 'C':
                    arr[list.get(k)] = 1;
                    Zstack.push(list.get(k));
                    list.remove(k);

                    if (k == last) {
                        k--;
                        last = k;
                    }
                    break;
                case 'Z':
                    int z = Zstack.pop();
                    arr[z] = 0;

                    if(z<list.get(k))
                        k++;

                    if(list.get(last)<z){
                        list.add(z);
                    }
                    else{
                        //list에 이분탐색으로 위치 집어넣기
                        int low = 0;
                        int high = last;
                        int mid;

                        while(low<high) {
                            mid = (low + high) / 2;

                            if(list.get(mid)>=z)
                                high=mid;
                            else
                                low=mid+1;

                        }
                        list.add(high, z);
                    }

                    break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0)
                answer += 'O';
            else
                answer += 'X';
        }

        System.out.println(answer);
        return answer;
    }
}