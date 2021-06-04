package im;

import java.util.*;
import java.io.*;

public class Main_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int numbers[] = new int[n];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < n; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}

		StringBuilder sb = new StringBuilder();
		int last = 0, temp = 0, top = 0; // last: 스택에 들어간 마지막 수
		boolean isAvailable = true;
		for (int i = 0; i < n; i++) {
			temp = numbers[i];
			if (last < temp) { // 현 수열의 수가 스택에 마지막으로 넣은 수보다 크면 그 숫자까지 스택에 쭉 넣었다가 다넣고 뺀다.
				for (int j = last + 1; j <= temp; j++) {
					stack.push(j);
					sb.append("+\n");
				}
				last = temp;
				stack.pop();
				sb.append("-\n");
			} else { // 현 수열의 수가 스택에 마지막으로 넣은 수보다 같거나 작다면 수가 이미 스택에 있어 넣을 수 없으니 빼야하는지 확인하기 위해 스택 탑 확인
				top = stack.peek();
				if (top == numbers[i]) { // 탑에 있는 수가 현 수열의 수가 맞다면 스택에서 빼기
					stack.pop();
					sb.append("-\n");
				} else { // 탑에 있는 수가 현 수열의 수가 아니라면 수열 생성 불가.
					isAvailable = false;
					break;
				}
			}
		}
		if (isAvailable)
			System.out.println(sb.toString());
		else
			System.out.println("NO");
	}

}