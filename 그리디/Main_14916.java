package greedy;

import java.io.*;
import java.util.*;

public class Main_14916 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// �ϴ� 5�� ������ 2�����鼭 ����غ�. �ϰ͵� ��� �ȵǸ� -1
		int cnt = 0;

		while (n > 0) {
			if (n % 5 == 0) {
				cnt = n / 5 + cnt;
				break;

			} else {
				n -= 2;
				cnt++;
			}
		}

		if (cnt < 0) {
			System.out.println("-1");
		} else {
			System.out.println(cnt);
		}

	}

}
