package greedy;

import java.io.*;
import java.util.*;

//B는 재배열 안하고,A만 재배열해야됨
//근데 계산할땐 A정방향 B역방향으로 정렬해서 곱한거 더해야되네
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
		// A에서 제일 큰거랑 B에서 제일 작은거 매칭, B에서 제일 큰거랑 A에서 제일 작은거 매칭 -> 이렇게 하면 최솟값 보장
		Arrays.sort(arrA);
		Arrays.sort(arrB);

		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += arrA[i] * arrB[N - i - 1];
		}
		System.out.println(sum);

	}

}
