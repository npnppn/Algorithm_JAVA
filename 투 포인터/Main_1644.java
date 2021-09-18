package binary_search;

import java.io.*;
import java.util.*;

public class Main_1644 {
	static boolean prime[];
	static ArrayList<Integer> primeList = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// ü�� �Ҽ����ϱ�
		prime = new boolean[N + 1];
		prime[0] = prime[1] = true;
		for (int i = 2; i * i <= N; i++) {
			if (!prime[i])
				for (int j = i * i; j <= N; j += i)
					prime[j] = true;
		}
		for (int i = 1; i <= N; i++) {
			if (!prime[i])
				primeList.add(i);
		}

		// �̺�Ž������ ������ Ȯ��
		int start = 0;
		int end = 0;
		int sum = 0;
		int cnt = 0;
		
		while (true) {
			if (sum >= N)
				sum -= primeList.get(start++);
			else if (end == primeList.size())
				break;
			else
				sum += primeList.get(end++);
			if (N == sum)
				cnt++;
		}
		System.out.println(cnt);
	}
}