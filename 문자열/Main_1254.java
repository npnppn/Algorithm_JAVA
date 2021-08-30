package string;

import java.io.*;
import java.util.*;

public class Main_1254 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(make(s));
	}

	static int make(String s) {
		int len = s.length();

		// 중간에서부터 팰린드롬 시작되면? substring으로 뽑아내면 되고
		for (int i = 0; i < len; i++) {
			String sub = s.substring(i);
			if (isTrue(sub)) {
				return i + len;
			}
		}
		// 팰린드롬이 아예 안되는거라면? -> 그럼 입력받은 문자열을 똑같이 하나 더 붙여주면 되는거니까 x2 혹은 + s.length() 하면될듯
		return len + len;
	}

	// 팰린드롬 판단. 주어진거 자체가 팰린드롬이면 그냥 냅두면 됨
	static boolean isTrue(String s) {
		int len = s.length();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != s.charAt(len - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
