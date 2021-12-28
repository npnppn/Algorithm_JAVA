package class2;

import java.io.*;
import java.util.*;

public class Main_11050 {
	static int n, k;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		System.out.println(combi(n, k));

	}
	
	//조합 경우의 수 전체 구하기
	static int combi(int n, int r) {
		if (n == r || r == 0)
			return 1;
		else
			return combi(n - 1, r - 1) + combi(n - 1, r); //선택할 경우 + 선택하지 않은 경우 계속해서 더하면됨

	}

}
