package baekjoon;

import java.io.*;
import java.util.*;

public class Main_10828 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>(); // 스택을 선언

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch (st.nextToken()) {
			
			case "push": //정수 x를 스택에 넣음
				stack.push(Integer.parseInt(st.nextToken()));
				break;
				
			case "pop": //스택 가장 위에 있는거 빼
				if (!stack.isEmpty())
					System.out.println(stack.pop());
				else
					System.out.println(-1);
				break;
				
			case "size": // 정수개수
				System.out.println(stack.size());
				break;
				
			case "empty": //비어있지 않으면, 0 아니면 1
				if (!stack.isEmpty())
					System.out.println(0);
				else
					System.out.println(1);
				break;
				
			case "top": //가장 위에 있는 정수 
				if (!stack.isEmpty())
					System.out.println(stack.peek());
				else
					System.out.println(-1);
				break;
			}
		}
	}
}