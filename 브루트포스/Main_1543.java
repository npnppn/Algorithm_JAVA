package algo;

import java.io.*;
import java.util.*;
//substring�� �ణ �򰥷ȴ�
public class Main_1543 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine(); // ���ڿ� �Է¹ް�
		char[] ch = input.toCharArray(); // �ϳ��� ����

		String word = br.readLine(); // �˻��ϰ� ���� �ܾ�
		int L = word.length();
		int cnt = 0;

		for (int i = 0; i <= ch.length - L; i++) {
			// i��°���� �˻��ϰ���� �ܾ� ���̱��� ���ڿ��� �߶� ����
			if (input.substring(i, i + L).equals(word)) {
				i += L - 1;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}