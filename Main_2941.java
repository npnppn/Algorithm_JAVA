package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_2941 {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		int len = s.length(); // 받은 문자열의 길이
		int cnt = 0;

		for (int i = 0; i < len; i++) {
			char ch = s.charAt(i);

			// c=랑 c-가 나올 때
			if (ch == 'c' && i < len - 1) {
				if (s.charAt(i + 1) == '=' || s.charAt(i + 1) == '-') {
					i++; // i+1 까지가 하나의 문자이므로 다음 문자를 건너 뛰기 위해 1 증가
				}
			}

			// d-랑 dz=가 나올 때
			else if (ch == 'd' && i < len - 1) {
				if (s.charAt(i + 1) == '-') {
					i++;
				}
				else if (s.charAt(i + 1) == 'z' && i < len - 2) {
					if (s.charAt(i + 2) == '=') {
						i += 2; // dz=는 3개를 한 단어로 치니까 문자 두개를 건너 뛰어야함
					}
				}
			}

			// lj, nj가 나올때
			else if ((ch == 'l' || ch == 'n') && i < len - 1) {
				if (s.charAt(i + 1) == 'j') {
					i++;
				}
			}

			// s=랑 z=가 나올때
			else if ((ch == 's' || ch == 'z') && i < len - 1) {
				if (s.charAt(i + 1) == '=') {
					i++;
				}
			}

			// 총 인덱스
			cnt++;

		}

		System.out.println(cnt);
	}

}
