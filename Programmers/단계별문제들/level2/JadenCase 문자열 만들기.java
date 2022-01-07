import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        
        //첫번째 글자를 대문자로 바꿔주고
        String firstStr = s.charAt(0) + "";
        answer.append(firstStr.toUpperCase());
        
        //공백 확인하면서 바꿔주자
        for (int i = 1; i < s.length(); i++) {
            String now = s.charAt(i) + "";
            if (now.equals(' ')) {
                answer.append(" ");
            }
            
            else if (s.charAt(i - 1) == ' ') {
                answer.append(now.toUpperCase());
            }
            else {
                answer.append(now.toLowerCase());
            }
        }
        
        return answer.toString();
    }
}
