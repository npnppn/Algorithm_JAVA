class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i<nums.length; i++) {
            for (int j = i+1; j<nums.length; j++) {
                for (int k = j+1; k<nums.length; k++) {
                    sum = nums[i] + nums[j] + nums[k];
                    if (prime(sum)) cnt++;
                    
                }
            }
        }
        answer = cnt;

        return answer;
    }
    
    static boolean prime(int n) {
        for (int i =2 ; i*i<=n; i++) {
            if( n % i == 0 ) return false;
        }
        return true;
        
    }
}
