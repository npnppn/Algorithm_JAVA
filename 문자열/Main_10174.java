package string;

import java.io.*;
import java.util.*;

public class Main_10174 {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			String s = br.readLine();
			boolean flag = true;
			String result = "";

			//�ҹ��ڳ� �빮�ڷ� �׳� �� �ٲٰ� ���ϸ� ���ϳ�!!
			s = s.toLowerCase();

			//System.out.println(s);

			for (int i = 0; i < s.length() / 2; i++) {
				// �Ǿպ��Ͷ� �ǵڿ������Ͷ� ���ؼ� �ٸ��� �Ӹ���� �ƴѰ�
				if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
					flag = false;
					break;
				}
			}
			if (flag) {
				result = "Yes";
			} else {
				result = "No";
			}
			System.out.println(result);
		}
	}
}