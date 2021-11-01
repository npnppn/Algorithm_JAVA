import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(long n) {
        String s = Long.toString(n);
        int len = s.length();
        int[] answer = new int[len];
        for (int i = 0; i<len; i++) {
            answer[i] = s.charAt(i) - '0';
        }
        //System.out.println(Arrays.toString(answer));
        
        for (int i = 0; i < answer.length / 2; i++) {
            int temp = answer[i];
            answer[i] = answer[answer.length - i - 1];
            answer[answer.length - i - 1] = temp;
        }
        return answer;
    }
}
