package ssafy_algo;

import java.util.Scanner;

public class Main_BOJ_17478 {
	public static int n; //입력 받는 숫자
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //숫자 입력 받음
		String first = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		System.out.println(first);
		recursive(0);
	}

	public static void recursive(int num) {
		String[] sArr = new String[6];
		String bar = "____";
		sArr[0] = "\"재귀함수가 뭔가요?\"";
		sArr[1] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		sArr[2] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		sArr[3] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		sArr[4] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
		sArr[5] = "라고 답변하였지.";
		
		if (num == n) { // 0일때는
			for (int i = 0; i < num; i++) {//0번째 문장 출력
				System.out.printf(bar);
			}
			System.out.println(sArr[0]);
			
			for (int i = 0; i < num; i++) {//4번째 문장 출력
				System.out.printf(bar);
			}
			System.out.println(sArr[4]);
			for (int i = 0; i < num; i++) {//5번째 문장 출력
				System.out.printf(bar);
			}
			System.out.println(sArr[5]);
			return;
			
		} else { // 0이 아닐때는
			for (int i = 0; i < num; i++) { //1번째 문장 출력
				System.out.printf(bar);
			}
			System.out.println(sArr[0]);
			
			for (int i = 0; i < num; i++) { //2번째 문장 출력
				System.out.printf(bar);
			}
			System.out.println(sArr[1]);
			
			for (int i = 0; i < num; i++) { //3번째 문장 출력
				System.out.printf(bar);
			}
			System.out.println(sArr[2]);
			
			for (int i = 0; i < num; i++) { //4번째 문장 출력
				System.out.printf(bar);
			}
			System.out.println(sArr[3]);
			
			recursive(num + 1); //재귀
			
			for (int i = 0; i < num; i++) { //모든 재귀가 끝나고 실행되는 부분
				System.out.printf(bar);
			}
			System.out.println(sArr[5]);
		}
	}

}
