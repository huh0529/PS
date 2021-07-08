package prgms;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 숫자문자열영단어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ans += s.charAt(i);
                continue;
            }
            switch (s.charAt(i)) {
                case 'z':
                    i += 3;
                    ans += '0';
                    break;
                case 'o':
                    i += 2;
                    ans += '1';
                    break;
                case 't':
                    if (s.charAt(i + 1) == 'w') {
                        i += 2;
                        ans += '2';
                    }
                    if (s.charAt(i + 1) == 'h') {
                        i += 4;
                        ans += '3';
                    }
                    break;
                case 'f':
                    if (s.charAt(i + 1) == 'o') {
                        i += 3;
                        ans += '4';
                    }
                    if (s.charAt(i + 1) == 'i') {
                        i += 3;
                        ans += '5';
                    }
                    break;
                case 's':
                    if (s.charAt(i + 1) == 'i') {
                        i += 2;
                        ans += '6';
                    }
                    if (s.charAt(i + 1) == 'e') {
                        i += 4;
                        ans += '7';
                    }
                    break;
                case 'e':
                    i+=4;
                    ans+='8';
                    break;
                case 'n':
                    i+=3;
                    ans+='9';
                    break;
            }
        }
        int answer = Integer.parseInt(ans);
        System.out.println(answer);
    }
}