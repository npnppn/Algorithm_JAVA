import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList <Integer> ar = new ArrayList<>();
        for (int i = 0 ; i<arr.length; i++) {
            if(arr[i] % divisor == 0) ar.add(arr[i]);
        }
        
        if(ar.size() == 0) {
            int [] answer2 = new int[1];
            answer2[0] = -1;
            return answer2;
        }
        int [] answer = new int[ar.size()];
        for (int i =0; i<answer.length; i++) {
            answer[i] = ar.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
