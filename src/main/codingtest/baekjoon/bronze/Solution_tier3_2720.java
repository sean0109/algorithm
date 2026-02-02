package main.codingtest.baekjoon.bronze;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * 
 
[문제]

미국으로 유학간 동혁이는 세탁소를 운영하고 있다. 동혁이는 최근에 아르바이트로 고등학생 리암을 채용했다.
동혁이는 리암에게 실망했다.
리암은 거스름돈을 주는 것을 자꾸 실수한다.
심지어 $0.5달러를 줘야하는 경우에 거스름돈으로 $5달러를 주는것이다!
어쩔수 없이 뛰어난 코딩 실력을 발휘해 리암을 도와주는 프로그램을 작성하려고 하지만, 디아블로를 하느라 코딩할 시간이 없어서 이 문제를 읽고 있는 여러분이 대신 해주어야 한다.
거스름돈의 액수가 주어지면 리암이 줘야할 쿼터(Quarter, $0.25)의 개수, 다임(Dime, $0.10)의 개수, 니켈(Nickel, $0.05)의 개수, 페니(Penny, $0.01)의 개수를 구하는 프로그램을 작성하시오. 
거스름돈은 항상 $5.00 이하이고, 손님이 받는 동전의 개수를 최소로 하려고 한다. 예를 들어, $1.24를 거슬러 주어야 한다면, 손님은 4쿼터, 2다임, 0니켈, 4페니를 받게 된다.

[입력]

첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 거스름돈 C를 나타내는 정수 하나로 이루어져 있다. C의 단위는 센트이다. (1달러 = 100센트) (1<=C<=500)

[출력]

각 테스트케이스에 대해 필요한 쿼터의 개수, 다임의 개수, 니켈의 개수, 페니의 개수를 공백으로 구분하여 출력한다.

[예제입력]

3
124
25
194

[예제출력]

4 2 0 4
1 0 0 0
7 1 1 4

*/

public class Solution_tier3_2720 {
	
	public void submitSolution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int [] coinPrice = {25, 10, 5, 1};
		int coinCount = 0;
		int loop = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < loop; i ++) {
			
			bw.write((i==0 ? "" : "\n"));
			
			int price = Integer.parseInt(br.readLine());
			
			for(int j = 0; j < coinPrice.length; j ++) {

				coinCount = price / coinPrice[j];
				price %= coinPrice[j];
				
				bw.write((j==0 ? "" : " ") + coinCount);
			}
		}
		bw.flush();
	}
	
	public void solution_1() throws Exception {
		
		System.out.println("solution_3 start");
		
		//String outputData = inputData().toString();
		StringBuffer outputData = inputData_1();					
		StringBuffer answerData = new StringBuffer();			// 정답
		
		//System.out.println("outputDATA : ");
		//System.out.print(outputData);
		
		// solve
		try {
			
			StringTokenizer st = new StringTokenizer(outputData.toString(), "\n");
			
			int loop = Integer.parseInt(st.nextToken());	// 거스름돈 개수
			//System.out.println("loop : " + loop);
			
			int quarter = 25; int dime = 10; int nickel = 5; int penny = 1;
			int coinCount = 0;			// 동전의 개수
			int coinValue = 0;			// 동전의 가격
			int tempPrice = 0;			// 나머지 값을 연산하기 위한 임시 변수
			
			// 거스름돈 개수만큼 for
			for(int i = 0; i < loop; i ++) {
				int change = Integer.parseInt(st.nextToken());
				//System.out.println("change : " + change);
				
				tempPrice =  change;			// 초기 값 세팅;
				
				for(int j = 0; j < 4; j ++) {

					if(j == 0) {
						coinValue = quarter;
					}else if(j == 1) {
						coinValue = dime;
					}else if(j == 2) {
						coinValue = nickel;
					}else if(j == 3) {
						coinValue = penny;
					}
					
					// 거스름돈 계산 로직
					// 1. 동전개수 구하기
					if( tempPrice >= coinValue ) {
						coinCount = tempPrice / coinValue;			// 쿼터 개수 
						tempPrice = tempPrice % coinValue;			// 나머지
						
					}else {
						coinCount = 0;
					}
					answerData.append(coinCount);
					answerData.append(" ");
					
				}
				answerData.append("\n"); //	한줄 건너띄기
			}
			
			//System.out.println("answerData : ");
			//System.out.print(answerData);
			
			
			
		}catch(Exception e) {
			
		}finally{
			
		}
	}
	
	
	// 데이터 입력
	public StringBuffer inputData_1() throws Exception{
		
		StringBuffer outputData = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			int n = Integer.parseInt(br.readLine());
			System.out.println(n + "개의 데이터를 입력해 주세요, 정수로 입력 , 하나씩 입력하고 Enter");
			outputData.append(n);
			outputData.append("\n");
			
			for(int i = 0; i < n; i ++) {
				String inputLinew = br.readLine();
				int s = Integer.parseInt(inputLinew);
				outputData.append(s);
				outputData.append("\n");
				
			}
			
			//System.out.println("outputData : ");
			//System.out.print(outputData);
			
			if(outputData == null || "".equals(outputData.toString().trim())) {
				throw new NullPointerException("There is no Data!!!");
			}
			
		}catch(Exception e) {
			System.out.println("program error has occured!!!");
			System.out.println("Exception : " + e.getMessage());
		}finally {
			// 할당 메모리 반납
			br.close();
		}
		
		
		return outputData;
	}
	
	
	public static void solution_2() throws Exception {
		System.out.println("solution_2");
		StringBuffer outputData = inputData_2();
		
		
	}
	
	public static StringBuffer inputData_2() throws Exception{
		
		StringBuffer outputData = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loop_1 = Integer.parseInt(br.readLine());
		outputData.append(loop_1);
		outputData.append("\n");
		
		for(int i = 0; i < loop_1; i ++) {
			String temp = br.readLine();
			StringTokenizer st = new StringTokenizer(temp);
			int loop_2 = Integer.parseInt(st.nextToken());
			outputData.append(loop_2);
			
			for(int j = 0; j < loop_2; j ++) {
				outputData.append(" ");
				outputData.append(Integer.parseInt(st.nextToken()));
			}
			
			outputData.append("\n");
		}
		
		System.out.println("outputData : ");
		System.out.println(outputData);
		
		return outputData;
	}
	
	public void solution_3() throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int quarter = 25; int dime = 10; int nickel = 5; int penny = 1;
		
		int loop = Integer.parseInt(br.readLine());
		int coinValue = 0;
		int tempPrice = 0;
		int coinCount = 0;
		
		for(int i = 0; i < loop; i ++) {
			tempPrice = Integer.parseInt(br.readLine());
			bw.write("\n");
			
			for(int j = 0; j < 4; j ++) {

				if(j == 0) {
					coinValue = quarter;
				}else if(j == 1) {
					coinValue = dime;
				}else if(j == 2) {
					coinValue = nickel;
				}else if(j == 3) {
					coinValue = penny;
				}
				
				if( tempPrice >= coinValue ) {
					coinCount = tempPrice / coinValue;			// 쿼터 개수 
					tempPrice %= coinValue;			// 나머지
					
				}else {
					coinCount = 0;
				}
				bw.write(coinCount + " ");
			}
		}
		bw.flush();
	}
	
		
	public static void main(String[] args) throws Exception{
		
		//new Solution_2720().solution_1();
		
		//new Solution_2720().solution_2();
		
		new Solution_tier3_2720().solution_3();
	}
	
}


 