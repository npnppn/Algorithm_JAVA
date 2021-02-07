package ssafy_algo;

import java.io.*;
import java.util.*;

public class Solution_D4_1223 {

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		for (int tc = 1; tc <= 10; tc++) {
			int n = Integer.parseInt(br.readLine()); // 입력받는 숫자
			Stack<Character> s = new Stack<Character>();
			String str = br.readLine();
			String postfix = ""; // 후위 표기식 문자열

			// 연산자부터 일단 계산
			for (int i = 0; i < str.length(); i++) {
				// 숫자면 바로 넣어줌
				if (str.charAt(i) != '+' && str.charAt(i) != '*')
					postfix += str.charAt(i);
				else {
					// 곱셈인 경우 스택에 바로 push
					if (str.charAt(i) == '*') {
						s.push(str.charAt(i));
					}
					// 덧셈인 경우 자기보다 우선순위가 높은 *을 빼고 push
					else {
						do {
							if (s.isEmpty())
								break;
							postfix += s.pop();
						} while (!s.isEmpty() && s.peek() != '+');
						s.push(str.charAt(i));
					}
				}
			}

			// 나머지 연산자 계산
			while (!s.isEmpty()) {
				postfix += s.pop(); // 나머지 연산자
			}

			// 계산하는 파트 구현
			Stack<Integer> calculator = new Stack<Integer>();
			for (int i = 0; i < postfix.length(); i++) {
				if (postfix.charAt(i) != '+' && postfix.charAt(i) != '*') // 피연산자인 경우 push
					calculator.push(postfix.charAt(i) - '0');
				// 연산자가 나오면 맨 위의 두개를 빼서 계산후 push
				else {
					int op1 = calculator.pop();
					int op2 = calculator.pop();
					char operator = postfix.charAt(i);
					switch (operator) {
					case '*':
						int result1 = op1 * op2;
						calculator.push(result1);
						break;
					case '+':
						int result2 = op1 + op2;
						calculator.push(result2);
						break;
					}
				}
			}

			System.out.println("#" + tc + " " + calculator.peek());
		}
	}
}