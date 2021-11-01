import java.io.*;
import java.util.*;

class Solution {
    static double res;
    public long solution(long n) {
        long answer = 0;
        if(zecop(n) == true) {
            answer = (long) Math.pow(res+1,2);
        } else {
            answer = -1;
        }
       
        return answer;
        
    }
    
    static boolean zecop(long n) {
        res = Math.sqrt(n);
        if (res % 1 > 0) return false;
        else return true;
    }
}
