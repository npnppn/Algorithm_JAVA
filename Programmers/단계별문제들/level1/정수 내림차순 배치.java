import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = Long.toString(n);
        int[] arr = new int[s.length()];
        for (int i =0 ; i< s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }
        Arrays.sort(arr);
        
        String str = "";
        for (int i =arr.length-1 ; i>-1; i--) {
            str += arr[i];
        }
        answer = Long.parseLong(str);
        return answer;
    }
}
