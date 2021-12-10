import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int [] first = {1,2,3,4,5};
        int [] second = {2,1,2,3,2,4,2,5};
        int [] third = {3,3,1,1,2,2,4,4,5,5};
        int [] cnt = {0, 0, 0};
        
        for (int i =0 ; i<answers.length; i++) {
            if(answers[i] == first[i%5]) {
                cnt[0]++;
            }
            if(answers[i] == second[i%8]) {
                cnt[1]++;
            }
            if(answers[i] == third[i%10]) {
                cnt[2]++;
            }
            
        }
        int maxScore = Math.max(Math.max(cnt[0], cnt[1]), cnt[2]);
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++){
            if(maxScore == cnt[i]){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int j=0; j<list.size(); j++){
            answer[j] = list.get(j);
        }
        
        
        return answer;
    }
}
