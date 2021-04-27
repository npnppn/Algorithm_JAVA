package baekjoon;

import java.io.*;
import java.util.*;

public class Main_10773 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(br.readLine()); // 숫자 입력받고
			// 0마주치면 빼버리고
			if (num == 0) {
				st.pop();
			} // 아니면 스택에 쌓음
			else {
				st.push(num);
			}
		}
		// System.out.println(st); //스택 확인

		int result = 0;
		for (int i : st) {
			result += i; // 각 요소 더해서 결과 출력하자
		}
		System.out.println(result);
	}

}
