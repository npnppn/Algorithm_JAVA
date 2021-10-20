package data_structure;

import java.io.*;
import java.util.*;

public class Main_16165 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
		int M = Integer.parseInt(st.nextToken()); // 퀴즈 수
		Map<String, String> hsm = new HashMap<>();
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String team = br.readLine();
			int num = Integer.parseInt(br.readLine());

			for (int j = 0; j < num; j++) {
				sb.append(br.readLine() + " ");
			}
			hsm.put(team, sb.toString());
			sb.setLength(0);
		}

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			int num = Integer.parseInt(br.readLine());
			arr.clear();

			if (num == 0) {
				StringTokenizer st2 = new StringTokenizer(hsm.get(str), " ");
				while (st2.hasMoreTokens()) {
					arr.add(st2.nextToken());
				}
				Collections.sort(arr);
				for (int j = 0; j < arr.size(); j++) {
					sb.append(arr.get(j) + "\n");
				}
			}

			// 1의 입력이 왔을때
			else {
				Iterator<String> it = hsm.keySet().iterator();
				while (it.hasNext()) {
					String key = it.next();
					StringTokenizer st3 = new StringTokenizer(hsm.get(key), " ");

					while (st3.hasMoreTokens()) {
						String strr = st3.nextToken();
						if (str.equals(strr)) {
							sb.append(key + "\n");
						}
					}
				}
			}
		}
		System.out.println(sb);

	}

}
