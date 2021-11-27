import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = {"zero", "one", "two", "three", "four", "five",
                        "six", "seven", "eight", "nine"};
        String[] str2 = {"0", "1", "2", "3", "4", "5", "6", "7","8", "9"};
        for(int i =0; i<10; i++) {
            s = s.replace(str[i], str2[i]);
        }
        answer = Integer.parseInt(s);
        
        return answer;
    }
}
