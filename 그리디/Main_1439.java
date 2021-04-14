package dongbina;

import java.io.*;
import java.util.*;

public class Main_1439 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char c = s.charAt(0); // 첫번째 글자
		int cnt0 = 0;
		int cnt1 = 0;

		//첫번째 글자 확인
		if (c == '0')
			cnt0++;
		else
			cnt1++;

		for (int i = 1; i < s.length(); i++) {
			char ch = s.charAt(i);
			//연속된거면 다음꺼로가
			if (ch == c)
				continue;
			
			// 0이면 0세고
			else if (ch == '0')
				cnt0++;
			
			// 0아니면 1을 세
			else
				cnt1++;
			c = ch;
		}

		System.out.println(Math.min(cnt0, cnt1));
	}

}
