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

		// �߰��������� �Ӹ���� ���۵Ǹ�? substring���� �̾Ƴ��� �ǰ�
		for (int i = 0; i < len; i++) {
			String sub = s.substring(i);
			if (isTrue(sub)) {
				return i + len;
			}
		}
		// �Ӹ������ �ƿ� �ȵǴ°Ŷ��? -> �׷� �Է¹��� ���ڿ��� �Ȱ��� �ϳ� �� �ٿ��ָ� �Ǵ°Ŵϱ� x2 Ȥ�� + s.length() �ϸ�ɵ�
		return len + len;
	}

	// �Ӹ���� �Ǵ�. �־����� ��ü�� �Ӹ�����̸� �׳� ���θ� ��
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
