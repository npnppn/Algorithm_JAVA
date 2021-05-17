import java.io.*;
import java.util.*;

//ArrayList 객체 쓰면 메모리초과, arrays.sort쓰면 시간초과? 
//카운팅 정렬로 풀어야겠구나!
public class Main_10989 {

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cnt = new int[10001];

		for (int i = 0; i < n; i++) {
			cnt[Integer.parseInt(br.readLine())]++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < cnt.length; i++) {
			while (cnt[i] > 0) {
				sb.append(i).append("\n");
				cnt[i]--; // 중복데이터가 있으므로 누적한 인덱스의 value 값을 한 개씩 줄임
			}
		}

		System.out.println(sb);

	}

}
