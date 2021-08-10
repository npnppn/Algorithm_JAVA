package dp;

import java.io.*;
import java.util.*;

public class Main_1932 {
//�Ʒ����� ���� �ö���� �ɷ� �ִ��� �����ߴ�
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n + 1][n + 1];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				//���� ���� �ö�ö��� �� �Ʒ� ���� ��ġ�� �����ʲ��� ū�ŷ� �����ϴϱ�
				arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]); 
			}
		}
		System.out.println(arr[0][0]); //�������� �ִ�!

	}

}
