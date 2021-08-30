package string;

import java.io.*;
import java.util.*;

public class Main_10988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean flag = true;

		for (int i = 0; i < s.length() / 2; i++) {
			// 맨앞부터랑 맨뒤에서부터랑 비교해서 다르면 팰린드롬 아닌겨
			if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

}
