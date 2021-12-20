import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if ((len == 4 || len == 6) && check(s)) answer = true;
        else answer = false;
        
        return answer;
    }
    
    static boolean check(String s) {
        int cnt = 0;
        for (int i = 0 ; i< s.length(); i++) {
            int ch = s.charAt(i) - '0';
            if(ch >=0 && ch <=9) {
                cnt++;
            }
        }
        if (cnt == s.length()) return true;
        else return false;
    }
}
