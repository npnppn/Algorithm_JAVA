package im;

import java.io.*;
import java.util.*;

// 숫자와 원하는 형태로 변환한 문자열을 같이 넣고 문자열의 사전순으로 정렬한 뒤 출력한다.
// 문자들을 정렬해야해서 컴패러블 사용
class Word implements Comparable<Word> {
	String word;// 규칙에 따라 문자열로 변환된 숫자
	int num;// 실제 숫자

	public Word(String word, int num) {
		super();
		this.word = word;
		this.num = num;
	}

	@Override
	public int compareTo(Word o) {// 사전 순 정렬
		return this.word.compareTo(o.word);
	}

}

public class Main_1755 {

	static int m, n;
	static ArrayList<Word> list; // 정렬될 변환된 문자열과 숫자가 들어가는 리스트
	// 10은 one zero로 표시하므로 0부터 9까지만 영어로 변환해줄 문자열 표시
	static String[] arr = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		list = new ArrayList<>();
		for (int i = m; i <= n; i++) {
			String temp = Integer.toString(i);
			char[] ch = temp.toCharArray();// 인덱스에 접근하기 쉽도록 문자 배열로 변환해준다.
			
			StringBuilder sb = new StringBuilder(); // 숫자를 문자열로 변환해줄 때 더해준다.
			for (int j = 0; j < ch.length; j++) {
				sb.append(arr[ch[j] - '0']);
				if (ch.length > 1) {
					sb.append(" ");// 각 숫자를 공백으로 구분해준다.
				}
			}
			list.add(new Word(sb.toString(), i)); // (변환된 문자열, 실제 숫자) 쌍을 리스트에 넣어준다.
		}

		Collections.sort(list); // 정렬해준다. compareTo에 따라 사전순 정렬~
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).num + " ");
			if ((i + 1) % 10 == 0) {// 10개를 출력한 후에는 줄바꿈
				System.out.println();
			}

		}
	}
}