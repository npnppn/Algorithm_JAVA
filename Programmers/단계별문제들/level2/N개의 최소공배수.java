import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        int tmp = arr[0];
        for (int i = 0; i<arr.length;i++) {
            tmp = lcm(arr[i], tmp); 
        }
        answer = tmp;
        return answer;
    }
    
    static int gcd(int x, int y) {
        while(y != 0) {
            int res = x % y;
            x = y;
            y = res;
        }
        return x;      
        
    }
    
    static int lcm(int x, int y) {
        return x*y/gcd(x,y);
    }
}
