import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = "";
        int copyN = n;
        s += copyN % 3;
        while(n/3 >=1 ) {
            n = n/3;
            s += n%3;
        }
        //System.out.print(s);
        
        for (int i = 0; i<s.length(); i++) {
            answer += Math.pow(3, s.length() - i-1) * (s.charAt(i) - '0');
        }
        return answer;
    }
}
