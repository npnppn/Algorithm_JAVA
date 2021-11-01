import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) return new int[]{-1};
        
        int minidx = 0;
        for(int i=0; i<arr.length; i++) {
            if(arr[minidx] > arr[i]) {
                    minidx = i;
            }
        }
        
        int[] answer = new int[arr.length-1];
        int cnt = 0;
        for(int i=0; i<arr.length; i++) {
            if(i == minidx) continue;
            answer[cnt++] = arr[i];
        }
        
        return answer;
    }
}
