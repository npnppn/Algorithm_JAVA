package binary_search;

import java.io.*;
import java.util.*;

//�Լ��� �������� Ǯ���!
public class Main_1644_2 {

	static int N, cnt;
	static boolean prime[];
	static ArrayList<Integer> primeList = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		cnt = 0;
		prime = new boolean[N + 1];

		primeCheck(); // �Ҽ� ����Ʈ �����
		sumCheck(); // ���� �� ����ϱ�
		System.out.println(cnt);
	}

	static void primeCheck() {
		prime[0] = prime[1] = true; // 1�� �Ҽ� �ƴϴϱ�
		for (int i = 2; i * i <= N; i++) {
			if (!prime[i]) {
				for (int j = i * i; j <= N; j += i) {
					prime[j] = true;
				}
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!prime[i]) {
				primeList.add(i);
			}
		}
	}

	static void sumCheck() {
		int sum;
		for (int i = 0; i < primeList.size(); i++) {
			sum = 0;
			for (int j = 0; j + i < primeList.size(); j++) {
				sum += primeList.get(i + j);

				if (sum == N) {
					cnt++;
					break;
				} else if (sum > N)
					break;
			}

		}

	}

}
