package string;

import java.io.*;
import java.util.*;

public class Main_1213 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int len = str.length();

		//���ĺ����� �ϴ� �迭���ٰ� ����
		int[] word = new int[26];
		for (int i = 0; i < len; i++) {
			word[str.charAt(i) - 'A']++;
		}

		int cnt = 0;
		int middle = 0;
		
		//������ Ȧ������ �װŸ� �߾Ӱ����� ��������
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
		// �� ó�� �κ�
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < word[i] / 2; j++) {
				result += (char) (i + 'A');
			}

		}

		// Ȧ�����϶��� �߾Ӱ� 1�� �ھƳ�
		if (cnt == 1) {
			result += (char) (middle + 'A');
		}

		// �߰����� ���κ�
		for (int i = 25; i >= 0; i--) {
			for (int j = 0; j < word[i] / 2; j++) {
				result += (char) (i + 'A');
			}
		}

		// ���� ������ �� ���ļ� ���
		System.out.println(result);

	}

}
