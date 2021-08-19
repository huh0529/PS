package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfStairs = Integer.parseInt(br.readLine());

        long[] dp = new long[numOfStairs + 1];

        dp[1] = 1;
        if (numOfStairs >= 2)
            dp[2] = 2;
        if (numOfStairs >= 3)
            dp[3] = 4;
        for (int i = 4; i <= numOfStairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }


        System.out.println(dp[numOfStairs]);

    }
}

class Solution1 {
    public long solution1(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료
        long answer = 0;

        //supplyAmount : 공급가액
        long b = 0;

        long sum = 0;
        sum = orderAmount - serviceFee;

        long st = sum - taxFreeAmount;
        if (st == 1)
            st = 0;

        b= (long) Math.floor(((long) (taxFreeAmount*0.1+st)) /1.1);

        answer = st - b;
        return answer;
    }
}

class Solution3 {
    public boolean solution3(String amountText) {
        boolean answer = true;

        int len = amountText.length();

        if (amountText.contains(",")) {
            for (int i = len - 1; i >= 0; i--) {
                if (len % 4 == (4 - i % 4) % 4) {
                    if (amountText.charAt(i) != ',') {
                        answer = false;
                        break;
                    }
                } else {
                    if (amountText.charAt(i) < '0' || amountText.charAt(i) > '9') {
                        answer = false;
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (amountText.charAt(i) < '0' || amountText.charAt(i) > '9') {
                    answer = false;
                    break;
                }
            }
        }

        if (len != 1)
            if (amountText.charAt(0) == 0 || amountText.charAt(0) == ',')
                answer = false;

        return answer;
    }
}

class Solution4 {
    public void solution4(String input) {
        String[] cmd = input.split("\\n");

        StringTokenizer st = new StringTokenizer(cmd[0]);
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int cnt=0;
        int day=0;
        for (int i = 1; i <cmd.length ; i++) {
            if(cmd[i].equals("SHOW")){
                if(cnt!=N){
                    System.out.println(1);
                    cnt++;
                }

            }
            else if(cmd[i].equals("NEGATIVE")) {

            }
            else if(cmd[i].equals("NEXT")) {

            }
            else if(cmd[i].equals("EXIT")){
                System.out.println("BYE");
                break;
            }
            else {
                System.out.println("ERROR");
            }
        }

    }
}

class Solution5 {
    public Integer[] solution5(int[] fruitWeights, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        int idx = 0;
        int i=0;
        while (i < fruitWeights.length-k) {
            int max=fruitWeights[i];
            for(int j=0;j<k;j++){
                if(fruitWeights[i+j]>max) {
                    max = fruitWeights[i + j];
                    idx = j;
                }
            }
            if(!list.contains(fruitWeights[i+idx]))
                list.add(fruitWeights[i+idx]);

            if(idx==0)
                i++;
            else
                i+=idx;
        }

        int size=list.size();
        Integer[] answer = list.toArray(new Integer[0]);

        return answer;
    }
}


class Solution6 {
    public long solution6(int numOfStairs) {
        long answer = 0;
        long[] dp = new long[numOfStairs + 1];

        dp[1] = 1;
        if (numOfStairs >= 2)
            dp[2] = 2;
        if (numOfStairs >= 3)
            dp[3] = 4;

        for (int i = 4; i <= numOfStairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        answer = dp[numOfStairs];
        return answer;
    }
}