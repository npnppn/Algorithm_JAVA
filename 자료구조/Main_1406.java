package data_structure;

import java.io.*;
import java.util.*;

public class Main_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(br.readLine());

		// 왼쪽(기존 문자)
		Stack<String> left = new Stack<String>();
		// 오른쪽(pop시 활용)
		Stack<String> right = new Stack<String>();

		for (int i = 0; i < input.length(); i++) {
			left.push(input.substring(i, i + 1));
		}

		for (int i = 0; i < n; i++) {
			String command = br.readLine();
			char c = command.charAt(0);
			if (c == 'L' && !left.isEmpty()) {
				right.push(left.pop());
			} else if (c == 'D' && !right.isEmpty()) {
				left.push(right.pop());
			} else if (c == 'B' && !left.isEmpty()) {
				left.pop();
			} else if (c == 'P') {
				left.push(String.valueOf(command.charAt(2)));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!left.isEmpty()) {
			right.push(left.pop());
		}
		while (!right.isEmpty()) {
			sb.append(right.pop());
			
		}
		System.out.print(sb);
	}
}