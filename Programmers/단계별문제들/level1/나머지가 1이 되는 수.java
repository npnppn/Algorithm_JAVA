class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int val = n - 1;
        for (int i = 2 ; i<=val; i++) {
            if(val % i == 0) {
                answer = i;
                break;
            }
        }
        
        
        return answer;
    }
}
