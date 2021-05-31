import java.util.*;
import java.io.*;

//별4, 동그라미3, 네모2, 세모1
//별 같으면 동그라미 확인, 동그라미 같으면 네모 확인, 네모 같으면 세모 확인, 다 같으면 무승부 
//A딱지 배열과 B딱지 배열이 필요하고, 배열에 각 딱지 갯수를 저장하면 되겠네
public class Main_14696 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 라운드 수
		for (int tc = 0; tc < n; tc++) {
			int aCount = sc.nextInt();
			int[] arrayA = new int[5]; // 각 딱지 개수를 저장하는 배열.. arrayA[4] 에는 4의 갯수, arrayA[3] 에는 3의 갯수 이런식!
			for (int i = 0; i < aCount; i++) {
				arrayA[sc.nextInt()]++; // 카드 갯수 저장
			}

			int bCount = sc.nextInt();
			int[] arrayB = new int[5];
			for (int i = 0; i < bCount; i++) {
				arrayB[sc.nextInt()]++; // 카드 갯수 저장
			}

			//System.out.println(Arrays.toString(arrayA));
			//System.out.println(Arrays.toString(arrayB));

			//별부터 차례대로 내려오면서 확인해보기
			char winner = 'D'; //기본을 비기는 것으로
			for (int i = 4; i > 0; i--) {
				
				if (arrayA[i] > arrayB[i]) {
					winner = 'A';
					break;
				}

				else if (arrayA[i] < arrayB[i]){
					winner = 'B';
					break;
				}
			}
			System.out.println(winner);
		}
	}

}
