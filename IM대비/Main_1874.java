import java.io.*;
import java.util.*;

public class Main_1874 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		Stack<Integer> st = new Stack<Integer>();
		int n = sc.nextInt();

		int start = 0;

		for (int k = 0; k < n; k++) {
			int val = sc.nextInt();

			if (val > start) {

				for (int i = start + 1; i <= val; i++) {
					st.push(i);
					sb.append("+").append("\n");
				}
				start = val; // 오름차순 유지하려면 초기화를 해놔야겠지
			}

			// 스택 맨 위가 입력값이랑 다르면 no출력
			else if (st.peek() != val) {
				System.out.println("NO");
				return;
			}
			st.pop();
			sb.append("-").append("\n");
		}
		System.out.println(sb);
	}

}
