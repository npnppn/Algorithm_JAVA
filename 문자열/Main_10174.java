package string;

import java.io.*;
import java.util.*;

public class Main_10174 {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			String s = br.readLine();
			boolean flag = true;
			String result = "";

			//소문자나 대문자로 그냥 싺 바꾸고 비교하면 편하네!!
			s = s.toLowerCase();

			//System.out.println(s);

			for (int i = 0; i < s.length() / 2; i++) {
				// 맨앞부터랑 맨뒤에서부터랑 비교해서 다르면 팰린드롬 아닌겨
				if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result = "Yes";
			} else {
				result = "No";
			}
			System.out.println(result);
		}
	}
}