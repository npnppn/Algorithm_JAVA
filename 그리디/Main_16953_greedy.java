package dfs_bfs;

import java.io.*;
import java.util.*;

//�׸���� ��������?? bfs�� �ؾ�����? ����ϴٰ� �� �� �غ����!
public class Main_16953_greedy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		int cnt = 0;

		while (a != b) {
			if (a > b) {
				System.out.println("-1");
				System.exit(0);
			}

			// A->B�� �ƴ϶� B->A�� ��������
			if (b % 10 == 1) {// �����ڸ� 1�� �Ǵ� ���
				b = b / 10;
			} else if (b % 2 == 0) {// 2�� �����������°��
				b = b / 2;
			} else {
				System.out.println("-1");
				System.exit(0);
			}
			cnt++;

		}
		System.out.println(cnt + 1);

	}

}
