package ssafy_algo;

import java.util.*;
import java.io.*;

public class Main_1755 { // class 시작
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 한줄 받아오기
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st; // 입력을 받아와서 공백 기준으로 분리하기 위한 변수
	static int N, M; // N : 시작 숫자 ,M : 끝 숫자
	static String[] english = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) throws Exception { // main 시작
		st = new StringTokenizer(br.readLine()); // 첫 줄을 받아온다.
		N = Integer.parseInt(st.nextToken()); // 첫번째 글자는 시작 숫자이다.
		M = Integer.parseInt(st.nextToken()); // 두번째 글자는 끝 숫자이다.
		char[] temp = new char[2]; // 두자리의 숫자인 경우 2개의 char형 배열로 만든다.
		String strTemp = ""; // String temp 변수로 16 인 경우 "one six" 가 된다.
		String[] result = new String[M - N + 1]; // 숫자에서 영어로 변환한 모든 String 변수가 담긴다.
		Map<String, Integer> mapTemp = new HashMap<>(); // key: 숫자가 영어로 변환된 String 변수, value: 영어로 변환 전 숫자

		for (int i = N; i <= M; i++) { // 시작 숫자부터 끝 숫자까지 1씩 키워간다.
			temp = String.valueOf(i).toCharArray(); // 받아온 숫자를 char형 변수 배열로 변환한다.
			//System.out.print(temp);
			strTemp = ""; // String temp 변수 초기화
			for (int j = 0; j < temp.length; j++) { // char형 변수 배열의 길이만큼 반복한다.
				strTemp += english[temp[j] - '0']; // 숫자에 해당하는 영어로 변환해 String 변수에 더한다.
				strTemp += " "; // 한 숫자가 끝나면 공백을 추가한다.
			}
			//System.out.print(strTemp);
			mapTemp.put(strTemp, i); // 숫자를 영어로 변환한 값을 key로, 기존 숫자를 value로 담는다.
			result[i - N] = strTemp; // 알파벳 기준 오름차순으로 정렬하기 위해 String 배열에 숫자를 영어로 변환한 값을 담는다.
		}
		Arrays.sort(result); // 알파벳 기준 오름차순으로 정렬

		int cnt = 0; // 10개가 되면 공백을 출력하기 위한 변수
		for (String str : result) { // 정렬된 String을 하나씩 빼온다.
			sb.append(mapTemp.get(str) + " "); // mapTemp에서 String이 key인 value(int 값)를 가져와 출력한다.
			cnt++; // 하나를 출력했으므로 cnt 1 증가
			if (cnt == 10) { // 10개가 출력됐으면
				cnt = 0; // cnt 0으로 초기화
				sb.append("\n"); // 공백 출력
			}
		}

		System.out.println(sb);

	}
}