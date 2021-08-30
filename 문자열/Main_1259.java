package string;

import java.io.*;
import java.util.*;

public class Main_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int s = sc.nextInt();
			
			//0입력받으면 종료
			if (s == 0)
				break;

			boolean flag = true;
			String str = Integer.toString(s); //숫자 입력받은거 문자열로 변환

			for (int i = 0; i < str.length() / 2; i++) {
				// 맨앞부터랑 맨뒤에서부터랑 비교해서 다르면 팰린드롬 아닌겨
				if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

		}

	}

}
