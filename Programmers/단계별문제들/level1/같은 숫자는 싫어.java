import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        for(int  i =0; i<arr.length ; i++){
            if(i==0){
                list.add(arr[i]);
            }else{
                if(arr[i]!=arr[i-1]){
                    list.add(arr[i]);
                }
            }
        }
        answer = new int[list.size()];
        for(int i =0 ; i<list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
