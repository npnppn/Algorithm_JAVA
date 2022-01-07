import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        int len = s.length();
        for (int i = 0; i<len; i++) {
            char ch = s.charAt(i);
            
            //공백
            if(ch == ' ') {
                answer += ch;
                continue;
            }
            //소문자
            if(ch >= 'a' && ch<='z') {
                if(ch + n > 'z') {
                    answer += (char) (ch - 26 + n);
                } else {
                    answer += (char) (ch + n);
                }
                
            }
            //대문자
            else if(ch >= 'A' && ch<='Z') {
                if(ch + n > 'Z') {
                    answer += (char) (ch - 26 + n);
                } else {
                    answer += (char) (ch + n);
                }
                
            }
        }
        
        return answer;
    }
}
