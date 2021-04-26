package baekjoon;

import java.io.*;
import java.util.*;

//생각한 로직은
//입력받은 값들을 오름차순 정렬해서 큰값부터 k와 비교해서 점점 내려가는거?
//아 근데 오름차순으로 가치가 주어지네. 그럼 정렬필요없고 바로 큰값부터 비교해보자
public class Main_11047 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n + 1];
		int cnt = 0;
		int remain = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = n-1; i >= 0; i--) {
			if (arr[i] <= k) {
				cnt += k / arr[i]; //4200원이면 1000원 4개 하고 200원이 남네. 그럼 이제 다음꺼로가서 찾자
				k = k % arr[i]; //200원 으로 이제 계속 비교
			}
		}

		System.out.println(cnt);

	}

}
