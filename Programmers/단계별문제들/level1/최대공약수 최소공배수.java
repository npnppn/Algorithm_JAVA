class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        int gcdNum = gcd(n, m);
        int lcmNum = n * m / gcdNum;
        answer[0] = gcdNum;
        answer[1] = lcmNum;
        return answer;
    }
    
    static int gcd(int n, int m) {
        if(m == 0) return n;
        else return gcd(m, n % m);
    }
}
