package data_structure;

import java.io.*;
import java.util.*;

//Ʈ���� �� �𸣰ھ ���۸����� ã�ƺ�.. ��Ƴ�
//���� �켱���� ť ������ 2�� : ������ �� �ѹ�, ������ ���� �ѹ�(�켱���� ������ , �켱���� ������)
//D 1 : Q���� �ִ��� ���� ����
//D -1 : Q���� �ּڰ��� ���� ����
public class Main_7662 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int k = sc.nextInt();
			TreeMap<Integer, Integer> ts = new TreeMap<>();
			
			for (int i = 0; i < k; i++) {
				char c = sc.next().charAt(0);
				int n = sc.nextInt();

				if (c == 'I') {
					ts.put(n, ts.getOrDefault(n, 0) + 1);
				} else if (!ts.isEmpty()) {
					int key;
					if (n == 1) {
						//�ִ� ����
						key = ts.lastKey();
						if (ts.get(key) > 1)
							ts.put(key, ts.get(key) - 1);
						else
							ts.pollLastEntry();
					}
					//�ּڰ� ����
					else {
						key = ts.firstKey();
						if (ts.get(key) > 1)
							ts.put(key, ts.get(key) - 1);
						else
							ts.pollFirstEntry();
					}
				}
			}
			if (ts.isEmpty())
				System.out.println("EMPTY");
			else
				System.out.println(ts.lastKey() + " " + ts.firstKey());

		}
	}
}