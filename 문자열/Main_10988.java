package string;

import java.io.*;
import java.util.*;

public class Main_10988 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		boolean flag = true;

		for (int i = 0; i < s.length() / 2; i++) {
			// �Ǿպ��Ͷ� �ǵڿ������Ͷ� ���ؼ� �ٸ��� �Ӹ���� �ƴѰ�
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
