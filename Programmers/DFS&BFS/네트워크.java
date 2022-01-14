import java.io.*;
import java.util.*;
//그냥 단순한 dfs 개념문제
class Solution {
    static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        for (int i = 0 ; i<n; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(i, computers, n);
                    answer++;
                }
            
        }
        return answer;
    }
    
    static void dfs(int node, int[][] computers, int n) {
        for (int i = 0; i<computers.length; i++) {
            if(!visited[i] && computers[i][node] == 1) {
                visited[i] = true;
                dfs(i, computers, n);
            }
        }
    }
}
