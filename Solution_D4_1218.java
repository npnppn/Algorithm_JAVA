package ssafy_algo;

import java.util.*;
import java.io.*;
/*
1) '{' , '[' , '<', '(' 기호가 나오면 스택에 담음
2) '}', ']', '>', ')' 닫는 기호가 나올 경우 스택에 담겨진 top의 기호와 쌍을 이루는지 확인!!!
3) 2의 조건을 만족하면 pop으로 스택의 top을 삭제
4) 모든 입력을 다 받아들인 후 스택이 비었다면 유효한 것! 
 */
public class Solution_D4_1218 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt(); // 테케 입력받음
			String s = sc.next();
			Stack <Character> st = new Stack<Character>();
			int r = 0;
			for(int i=0;i<s.length();i++) {
				char c = s.charAt(i);
				if(c == ')' && st.peek() == '(') st.pop();
				else if(c == ']' && st.peek() == '[') st.pop();
				else if(c == '}' && st.peek() == '{') st.pop();
				else if(c == '>' && st.peek() == '<') st.pop();
				else {
					st.push(c);
				}
			}
			if(st.isEmpty()) r=1;
			else r =0;
			System.out.println("#" + tc + " " + r);
		}
	}
}