import java.io.*;
import java.util.*;

//n  x  n-x  2x-n  -3x+2n  5x-3n  ....
public class Main_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = 0;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = n; i >= n / 2; i--) {
			ArrayList<Integer> al = new ArrayList<Integer>();
			al.add(n);
			int tmp = n;
			int number = i; //두번째 숫자
			while (true) {
				
				//음수면 종료
				if (tmp < 0)
					break;
				int t = tmp;
				
				//두번째 숫자가 0보다 크거나 같으면 리스트에 추가
				if (number >= 0)
					al.add(number);
				
				//n-2번째에서 n-1번째를 빼야지
				tmp = number;
				number = t - tmp;

			}
			if (max < al.size()) {
				max = al.size();
				result = al;
			}

		}
		System.out.println(result.size());
		for (int i : result) {
			System.out.print(i + " ");
		}

	}

}
