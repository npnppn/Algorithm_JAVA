class Solution {
    boolean solution(String s) {
        //대문자로 굳이 안바꾸고 한번에 P이거나 p인걸 해도 되겠군
        boolean answer = true;
        int cntP = 0;
        int cntY = 0;

        s = s.toUpperCase();
        System.out.println(s);
        for (int i =0 ; i<s.length(); i++) {
            if(s.charAt(i) == 'P') cntP++;
            if(s.charAt(i) == 'Y') cntY++;
        }
        if (cntP != cntY) answer = false; 
        
        return answer;
    }
}
