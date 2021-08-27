package brute_force;

import java.io.*;
import java.util.*;

public class Main_1969 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken()); // dna��
		int m = Integer.parseInt(st.nextToken()); // ���ڿ� ����
		String[] dna = new String[n]; // dna �����ϴ� �迭
		int sum = 0; // �ع��ڵ� �ּ���
		String result = "";

		for (int i = 0; i < n; i++) {
			dna[i] = br.readLine();
		}

		for (int i = 0; i < m; i++) {
			int[] cnt = new int[4]; // A T C G ���� �迭
			for (int j = 0; j < n; j++) {
				char ch = dna[j].charAt(i);

				if (ch == 'A') {
					cnt[0]++;
				} else if (ch == 'C') {
					cnt[1]++;
				} else if (ch == 'G') {
					cnt[2]++;
				} else { // G�϶�
					cnt[3]++;
				}

			}

			int res = cnt[0];
			int index = 0;

			// ���� ���� ���� ���ĺ� Ž��
			for (int k = 1; k < 4; k++) {
				if (cnt[k] > res) {
					res = cnt[k];
					index = k;
					// System.out.println(index);
				}
			}

			// Ž�� �� ��� ���ڿ��� ����
			if (index == 0) {
				result += 'A';
			} else if (index == 1) {
				result += 'C';
			} else if (index == 2) {
				result += 'G';
			} else {
				result += 'T';
			}

		}

		System.out.println(result);

		// �ּ��� ã��
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (result.charAt(i) != dna[j].charAt(i)) {
					sum++;
				}
			}
		}

		// System.out.println(result);
		System.out.println(sum);

	}

}
