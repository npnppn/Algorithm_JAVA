import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        int len = nums.length/2;
        
        Set <Integer> s = new HashSet<>();
        for (int i =0; i<nums.length; i++) {
            s.add(nums[i]);
        }
        answer = Math.min(len, s.size());
        
        return answer;
    }
}
