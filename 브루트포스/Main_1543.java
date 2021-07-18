package algo;

import java.io.*;
import java.util.*;
//substring이 약간 헷갈렸다
public class Main_1543 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); // 문자열 입력받고
		char[] ch = input.toCharArray(); // 하나씩 저장

		String word = br.readLine(); // 검색하고 싶은 단어
		int L = word.length();
		int cnt = 0;

		for (int i = 0; i <= ch.length - L; i++) {
			// i번째부터 검색하고싶은 단어 길이까지 문자열을 잘라서 비교해
			if (input.substring(i, i + L).equals(word)) {
				i += L - 1;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}