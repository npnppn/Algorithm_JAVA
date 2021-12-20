import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int len = s.length();
        int val = len/2;
        if(len % 2 == 1) {
            answer += s.charAt(val);
        } else {
            answer += s.substring(val-1,val+1);
        }
        
        return answer;
    }
}
