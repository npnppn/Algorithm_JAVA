import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        Set <Integer> ar = new HashSet<>();
        for (int i = 0 ; i< numbers.length; i++) {
            for (int j = i+1; j<numbers.length; j++) {
                ar.add(numbers[i] + numbers[j]);
            }
        }
        //System.out.println(ar);
        
        ArrayList<Integer> list = new ArrayList<>(ar);
        Collections.sort(list);
        int [] answer = new int[list.size()];
        for (int i = 0 ;i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
