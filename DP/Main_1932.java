package dp;

import java.io.*;
import java.util.*;

public class Main_1932 {
//아래에서 위로 올라오는 걸로 최댓값을 갱신했다
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
				//위로 한층 올라올때는 그 아래 층의 위치와 오른쪽꺼중 큰거로 골라야하니까
				arr[i - 1][j] += Math.max(arr[i][j], arr[i][j + 1]); 
			}
		}
		System.out.println(arr[0][0]); //맨위층이 최댓값!

	}

}
