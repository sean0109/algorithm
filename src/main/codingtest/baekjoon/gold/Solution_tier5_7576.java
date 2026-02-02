package main.codingtest.baekjoon.gold;
/*
	문제 : 토마토
	난이도 : 골드 5
	알고리즘 : 그래프이론, 그래프 탐색, 너비 우선 탐색, 최단 경로, 격자 그래프
	시간제한 : 1초
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_tier5_7576 {
	
	// 토마토
	private int M, N;
	private int[][] tomatoes;	// 토마토 상자의 토마토 행렬
	private int count;			// 안익은 토마토 개수
	private int days;			// 토마토가 익어가는 날짜

	// 좌표 탐색 이동량
	private int[] dx = {1, -1, 0, 0 };
	private int[] dy = {0, 0, 1, -1};

	private void solution_1() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());	// y#
		N = Integer.parseInt(st.nextToken());	// x
		tomatoes = new int[N][M];

		Queue<int[]> queue = new LinkedList<int[]>();

		for(int i = 0; i < N; i ++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j ++){
				int tomato = Integer.parseInt(st.nextToken());
				tomatoes[i][j] = tomato;
				if(tomato == 0){
					count ++;	// 익혀야할 토마토 개수 추가
				}else if (tomato == 1){
					queue.offer(new int[]{i, j});	// 익은 토마토 좌표 저장
				}
			}
		}

		// * 구현 조건
		// 1. 방향이 정해져 있는 탐색. ("하루가 지났다" 라는 비지니스 로직 작성, => 1일 추가 )
		// 2. 탐색 조건 : 모든 토마토가 다 익을때 까지. count == 0 이 될때 까지
		// 3. return -1 조건 : 하루가 지났는데도, count의 변화량이 없을 경우 (토마토를 익힐 수 없다고 판단)
		// 4. 자료구조 및 알고리즘 : queue로 bfs 탐색.
		//   (단, 탐색의 방향은 정해져 있음. 하루가 지난 후의 토마토 상자 내의 토마토 상태는 정해져있음)
		
		// 토마토가 다 익을 때 까지
		while(count > 0){
			// 하루 단위 탐색
			Set<int[]> newtTomatoes = new HashSet<>();	// 새롭게 익은 토마토
			while (!queue.isEmpty()){
				int[] tomato = queue.poll();
				int cx = tomato[0];
				int cy = tomato[1];
				// 주변 토마토 익히고
				for(int i = 0 ; i < 4; i ++){
					int nx = cx + dx[i];
					int ny = cy + dy[i];

					if(nx >= 0 && nx < N && ny >= 0 && ny < M && tomatoes[nx][ny] == 0){
						tomatoes[nx][ny] = 1;						// 토마토 익히고
						newtTomatoes.add(new int[]{nx, ny});		// 새롭게 익은 토마토 좌표 추가
						// 익은 토마토 개수 차감
						count --;
					}
				}
			}

			if(newtTomatoes.isEmpty() && count > 0){ // 만약 새롭게 익은 토마토가 존재하지 않는데, 익어야할 토마토가 남아있으면
				System.out.println(-1);		// 탐색 종료.
				return;
				//break;
			}
			
			// 새로운 좌표 추가
			for(int [] tomato : newtTomatoes){
				queue.offer(new int[]{tomato[0], tomato[1]});	// 익은 토마토 좌표 저장
			}
			days ++;	// 날짜 하루 증가
		}
		System.out.println(days);	// 정답 출력
	}

	public static void main(String[] args) throws Exception{
		new Solution_tier5_7576().solution_1();
	}
}