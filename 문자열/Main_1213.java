package string;

import java.io.*;
import java.util.*;

public class Main_1213 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();

		//알파벳갯수 일단 배열에다가 ㄱㄱ
		int[] word = new int[26];
		for (int i = 0; i < len; i++) {
			word[str.charAt(i) - 'A']++;
		}

		int cnt = 0;
		int middle = 0;
		
		//갯수가 홀수개면 그거를 중앙값으로 넣을거임
		for (int i = 0; i < 26; i++) {
			if (word[i] % 2 != 0) {
				middle = i;
				cnt++;
			}
		}

		if (cnt > 1 || (cnt == 1 && len % 2 == 0)) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}
		//System.out.println(Arrays.toString(word));

		String result = "";
		// 맨 처음 부분
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < word[i] / 2; j++) {
				result += (char) (i + 'A');
			}

		}

		// 홀수개일때는 중앙값 1개 박아놔
		if (cnt == 1) {
			result += (char) (middle + 'A');
		}

		// 중간부터 끝부분
		for (int i = 25; i >= 0; i--) {
			for (int j = 0; j < word[i] / 2; j++) {
				result += (char) (i + 'A');
			}
		}

		// 위에 세개를 다 합쳐서 출력
		System.out.println(result);

	}

}
