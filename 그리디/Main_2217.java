package baekjoon;

import java.util.*;
import java.io.*;
// 병렬로 연결할 때 최대 중량을 결정하는 것은
// 포함된 로프들 중 가장 적은 중량을 드는 로프가 버틸 수 있는 중량

public class Main_2217 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n+1];
		int result = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		for (int i = 1; i <= n; i++) {
			result = Math.max(result, arr[i] * (n - (i - 1))); //해당 로프 중량 * 해당 로프부터 마지막 로프까지의 갯수
		}
		System.out.println(result);

	}

}
