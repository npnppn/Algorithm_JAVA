import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i =0; i<10; i++) {
            set.add(i);
        }
        
        for (int i=0; i<numbers.length; i++) {
            if(set.contains(numbers[i])) {
                set.remove(numbers[i]);
            }
        }
        
        int result = 0;
        for (int k : set) {
            result += k;
        }
        
        return result;
    }
}
