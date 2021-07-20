package algo;

import java.io.*;
import java.util.*;

public class Main_5397 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {

			Stack<Character> st1 = new Stack<>();
			Stack<Character> st2 = new Stack<>();

			String str = br.readLine();

			// <가 나오면 다른 스택에 넣어주고
			// >가 나올 때 다시 꺼내서 원래 스택에 넣어준다.
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '<') {
					if (!st1.isEmpty()) {
						st2.push(st1.pop());
					}
				}

				else if (str.charAt(i) == '>') {
					if (!st2.isEmpty()) {
						st1.push(st2.pop());
					}
				}

				else if (str.charAt(i) == '-') {
					if (!st1.isEmpty()) {
						st1.pop();
					}
				}

				else {
					st1.push(str.charAt(i));
				}
			}

			// 다른 스택이 비어질때까지 정답 스택에 집어넣어
			while (!st2.isEmpty()) {
				st1.push(st2.pop());
			}

			StringBuilder sb = new StringBuilder();
			while (!st1.isEmpty()) {
				sb.append(st1.pop());
			}
			System.out.println(sb.reverse());
		}
	}
}