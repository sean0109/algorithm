package main.algorithm;

public class SortingAlgorithm_01 {
		
	/*	
		성공은 결정적이지 않고, 실패는 치명적이지 않다.
		중요한 것은 용기를 계속 갖는 것이다.		- 윈스턴 처칠
	*/	
	
	// 1. 버블정렬
	private static void doBubbleSort() {
		
		int [] arr = {5, 3, 8, 4, 2, 7, 1, 6};
		
		boolean swapped = false;
		
		// 1.버블 정렬 : 인접한 두 수를 비교해서 큰 값을 뒤로 보낸다. 비교 후 이동 방식 swap. 시간 복잡도 : o(n2)
		for(int i = 0; i < arr.length - 1; i ++) {	// 마지막 요소는 볼 필요 없으므로, arr.length - 1;
			swapped = false;
			
			// 뒤에서부터 정렬한 것이 쌓이므로, 탐색 요소가 뒤에서 하나씩 줄어든다. arr.length - i -1
			for(int j = 0 ; j < arr.length - i - 1; j++ ) {
				if(arr[j] > arr[j+1]) {
					// swapped
					int temp = arr[j];
					arr[j] = arr[j+1]; // 위치 바꿈
					arr[j+1] = temp;
					swapped = true;
				}
			}
			if(!swapped) break; // 한바퀴 돌았는데 한번도 정렬이 안일어났으면 이미 정렬된 상태
		}
		
		// 출력 검증
		System.out.println("버블정렬 : ");
		for(int n : arr) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
	
	private static void doSelectionSort() {
		
		int [] arr = {5, 3, 8, 4, 2, 7, 1, 6};
		
		// 2. 선택 정렬 : 최소값을 앞으로 하나씩 보낸다. 비교 후 이동 방식 swap. 시간 복잡도 : o(n2)
		for(int i = 0; i < arr.length - 1; i ++ ) {	// 마지막 요소는 볼필요 없으므로, arr.length - 1
			int minIndex = i;
			
			// 앞에서부터 하나씩 쌓이므로 시작점이 i+1로 달라질뿐 끝 지점은 arr.length;로 고정
			for(int j = i + 1; j < arr.length; j ++) {
				if(arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			
		}
		System.out.println("선택정렬 : ");
		for (int n : arr) {
            System.out.print(n + " ");
		}
		System.out.println();
	}
	// 3. 삽입정렬 : 자기 위치를 찾아 삽입한다. shift 이동 방식. 시간 복잡도 o(n)
	private static void doInsertionSort() {
		
		int [] arr = {5, 3, 8, 4, 2, 7, 1, 6};

		for(int i = 1; i < arr.length; i ++) {	// 첫번째 요소는 정렬 되어 있다고 가정하기 때문에 i = 1 부터 시작
			int key = arr[i];	// 삽입할 대상
			int j = i - 1;
			
			// 키 값 보다 큰 값을 오른쪽으로 이동
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j --;
			}
			// key를 알맞은 자리에 삽입
			arr[j+1] = key;
		}
		System.out.println("삽입정렬 : ");
		for (int n : arr) {
            System.out.print(n + " ");
		}
		System.out.println();
	}
	// 4. 퀵 정렬 . 분할 지점 (pivot) 을 정하고 왼쪽과 오른쪽으로 나누어서 정렬
	private static class QuickSort{
		
		private QuickSort() {
			this.main();
		}
		
		private void quickSort(int[] arr, int low, int high) {
	        if (low < high) {
	            int pivotIndex = partition(arr, low, high);

	            quickSort(arr, low, pivotIndex - 1);   // 왼쪽 정렬
	            quickSort(arr, pivotIndex + 1, high);  // 오른쪽 정렬
	        }
	    }
		
		private int partition(int[] arr, int low, int high) {
	        int pivot = arr[high];  // 마지막 요소를 피벗으로 선택
	        int i = low - 1;

	        for (int j = low; j < high; j++) {
	            if (arr[j] < pivot) {
	                i++;
	                // swap arr[i] ↔ arr[j]
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }

	        // pivot을 기준 위치로 이동
	        int temp = arr[i + 1];
	        arr[i + 1] = arr[high];
	        arr[high] = temp;

	        return i + 1;  // pivot의 최종 위치
	    }
		
		private void main() {
	        int[] arr = {5, 3, 8, 4, 2, 7, 1, 6};
	        quickSort(arr, 0, arr.length - 1);

	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	    }
		
	}

	// 5. 병합 정렬 : 계속 쪼개서 2개가 남을 때 까지 정렬
	private static class MergeSort {
		
	}
	
	
	
	// 정렬 알고리즘 (버블, 선택, 삽입, 퀵, 병합)
	public static void main(String[] args) {
		
		//doBubbleSort();		// 버블 정렬
		
		//doSelectionSort();	// 선택 정렬
	
		//doInsertionSort();	// 삽입 정렬
		
		new QuickSort();		// 퀵정렬

		new MergeSort();		// 병합 정렬
	}
}
