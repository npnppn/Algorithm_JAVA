package ssafy_algo;

import java.util.*;
import java.io.*;

/* 배열로 푸니까 시간초과..
   스택이 비어있으면 0,
   스택이 안비어있을땐, 스택top이 현재값보다 크면 top의 인덱스 출력하고 스택에 푸시!
   작으면 top을 pop해주는걸 계속해보자
  몇 번째인지 알아내라고 했으니까 스택에 탑의 높이 말고도 인덱스도 저장해야되네.
 */

public class Main_BOJ_2493 {

	public static void main(String[] args) throws Exception, IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		int n = Integer.parseInt(br.readLine());
		StringTokenizer tk = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		Stack<Tower> stack = new Stack<>();

		for (int i = 1; i <= n; i++) {
			int height = Integer.parseInt(tk.nextToken()); //높이 입력받음
			while (!stack.isEmpty()) {
				if (stack.peek().height >= height) { //최고높이랑 현재 높이랑 비교해
					sb.append(stack.peek().index + " "); //스택값이 현재값보다 크면 인덱스 출력
					break;
				} else {
					stack.pop(); //스택값이 현재값보다 작으면 스택값을 제거
				}
			}
			if (stack.isEmpty()) {
				sb.append("0 "); //스택이 비어있을땐 0 출력
			}
			stack.push(new Tower(i, height)); //인덱스, 높이
		}
		System.out.println(sb);
	}

	static class Tower { //타워 스택의 정보 -> 인덱스값이랑 높이값이 필요함!
		int index;
		int height;

		Tower(int index, int height) {
			this.index = index;
			this.height = height;
		}
	}

}
