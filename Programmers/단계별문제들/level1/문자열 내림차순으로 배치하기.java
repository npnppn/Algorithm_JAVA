import java.io.*;
import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        char[] str = new char[s.length()];
        
        for (int i = 0; i < str.length; i++) {
            str[i] = s.charAt(i);
        }
        Arrays.sort(str);
        sb.append(str);
        sb.reverse();
 
        return sb.toString();
    }
}
