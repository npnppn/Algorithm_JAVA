package string;

import java.io.*;
import java.util.*;

public class Main_1259 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int s = sc.nextInt();
			
			//0�Է¹����� ����
			if (s == 0)
				break;

			boolean flag = true;
			String str = Integer.toString(s); //���� �Է¹����� ���ڿ��� ��ȯ

			for (int i = 0; i < str.length() / 2; i++) {
				// �Ǿպ��Ͷ� �ǵڿ������Ͷ� ���ؼ� �ٸ��� �Ӹ���� �ƴѰ�
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
