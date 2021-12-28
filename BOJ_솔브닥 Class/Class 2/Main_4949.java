package class2;

import java.io.*;
import java.util.*;

//스택이 비어있는지로 판단하면 간단히 해결!
public class Main_4949 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s;

		while (true) {
			s = sc.nextLine();
			if (s.equals(".")) {
				break;
			}

			Stack<Character> st = new Stack<>();

			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);

				if (ch == '[' || ch == '(') {
					st.push(ch);
				}

				else if (ch == ')') {
					if (st.isEmpty() || st.peek() != '(') {
						st.push(ch);
						break;
					} else {
						st.pop();

					}
				}

				else if (ch == ']') {
					if (st.isEmpty() || st.peek() != '[') {
						st.push(ch);
						break;
					} else {
						st.pop();
					}
				}

			}

			if (st.isEmpty()) {
				System.out.println("yes");

			} else {
				System.out.println("no");

			}

		}
	}

}
