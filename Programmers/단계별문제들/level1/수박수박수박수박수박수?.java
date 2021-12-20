import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n) {
        String answer = "";
        String res = "수박";
        if (n % 2 == 0) {
            for (int i = 0 ; i<n/2; i++) {
                answer += res;
            }
        } else {
            for (int i = 0 ; i<n/2; i++) {
                answer += res;
            }
            answer += '수';
        }
        return answer;
    }
}
