package ssafy_algo;

import java.util.*;
import java.io.*;

/*
 '('와 ')'가 연속으로 입력되는 경우(현재까지 쌓인 쇠막대기를 자르는 경우)
 -> 잘려진 쇠막대기의 개수가 쌓인 쇠막대기만큼 증가한다.

  위 조건을 만족하지 않으면서 '('가 들어오는 경우(쇠막대기를 하나 더 쌓는 경우)
  -> 현재 쌓여있는 쇠막대기에 하나 더 쌓는다.

 맨위 조건을 만족하지 않으면서 ')'가 들어오는 경우(쇠막대기의 길이가 다한 경우)
 -> 쌓여있는 쇠막대기의 개수를 하나 감소시키고, 잘려진 쇠막대기의 수를 하나 증가시킨다.
 */

public class Solution_D4_5432 {
	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();

		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String s = sc.next();
			char[] arr = new char[s.length()]; //막대기 담을 스택
			int res = 0;

			for (int i = 0; i < s.length(); i++) {
				// System.out.print(s.charAt(i) + " ");
				arr[i] = s.charAt(i);
			}
			for (int i = 0; i < arr.length; i++) {

				if (arr[i] == '(') { // (기호 있으면 스택에 삽입
					stack.push(arr[i]);
				}

				else if (arr[i] == ')' && arr[i - 1] == '(') { //쇠막대기 하나 더 쌓을때
					stack.pop();
					res += stack.size();
				}

				else if (arr[i] == ')' && arr[i - 1] == ')') { // ) )이면 스택에서 ( 없앰
					stack.pop();
					res += 1;
				}

			}

			System.out.println("#" + t + " " + res);
		}
	}
}
	
	
/* 밑에는 스택 안쓰고 푼 케이스..
	public static void main(String[] args) throws Exception, IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int tc = 1; tc <= t; tc++) {
			String s = sc.next();
			int n = s.length();
			int result = 0; // 쌓여있는 쇠막대기 수
			int cnt = 0; // 잘려진 쇠막대기수

			for (int i = 0; i < n - 1; i++) {
				if (s.charAt(i) == '(' && s.charAt(i + 1) == ')')
					cnt += result;
				else if (s.charAt(i) == ')' && s.charAt(i - 1) == '(')
					continue;
				else if (s.charAt(i) == '(')
					result++;
				else if (s.charAt(i) == ')') {
					if (result > 0) {
						result--;
						cnt++;
					}
				}
			}
			cnt++;
			System.out.println("#" + tc + " " + cnt);
		}
	}
}*/