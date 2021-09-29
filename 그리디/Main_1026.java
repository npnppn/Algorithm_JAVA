package greedy;

import java.io.*;
import java.util.*;

//B�� ��迭 ���ϰ�,A�� ��迭�ؾߵ�
//�ٵ� ����Ҷ� A������ B���������� �����ؼ� ���Ѱ� ���ؾߵǳ�
public class Main_1026 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arrA[] = new int[N];
		int arrB[] = new int[N];
		for (int i = 0; i < N; i++) {
			arrA[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			arrB[i] = sc.nextInt();
		}
		// 1 1 1 6 0 -> 1 1 0 1 6
		// 2 7 8 3 1 -> 2 7 8 3 1
		// A���� ���� ū�Ŷ� B���� ���� ������ ��Ī, B���� ���� ū�Ŷ� A���� ���� ������ ��Ī -> �̷��� �ϸ� �ּڰ� ����
		Arrays.sort(arrA);
		Arrays.sort(arrB);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arrA[i] * arrB[N - i - 1];
		}
		System.out.println(sum);

	}

}
