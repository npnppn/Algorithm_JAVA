package ssafy_algo;

import java.util.Scanner;

public class Solution_D3_1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T, answer = 0;
		String input;
		T = sc.nextInt();
		input = sc.nextLine();
		for (int test_case = 1; test_case <= T; test_case++) {
			input = sc.nextLine();
			char idx_char = '0';
			for (int i = 0; i < input.length(); i++) {
				if (idx_char != input.charAt(i)) {
					if (idx_char == '0') {
						idx_char = '1';
					} else if (idx_char == '1') {
						idx_char = '0';
					}
					answer += 1;
				}
			}

			System.out.println("#" + test_case + " " + answer);
			input = "";
			answer = 0;
		}
	}
}