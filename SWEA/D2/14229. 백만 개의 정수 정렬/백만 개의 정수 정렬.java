
//import java.util.Scanner;
//
//public class Solution {
//    static int[] arr = new int[1000000];
//    static int[] temp = new int[1000000];
//    
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        
//        int inputCount = 100000; // 실제 입력 개수
//        
//        for (int i = 0; i < inputCount; i++) {
//            arr[i] = sc.nextInt();
//        }
//        
//        // 입력한 범위만 정렬
//        sort(0, inputCount - 1);
//        
//        // 예시: 중앙값 출력 (100,000개면 중앙은 arr[50000])
//        System.out.println(arr[inputCount / 2]);
//        sc.close();
//    }
//    
//    private static void sort(int start, int end) {
//        if (start < end) {
//            int mid = (start + end) / 2;
//            sort(start, mid);
//            sort(mid + 1, end); // 여기서 end를 사용해야 함.
//            merge(start, mid, end);
//        }
//    }
//    
//    private static void merge(int start, int mid, int end) {
//        int left = start;
//        int right = mid + 1;
//        int idx = start;
//        
//        while (left <= mid && right <= end) {
//            if (arr[left] <= arr[right]) {
//                temp[idx++] = arr[left++];
//            } else {
//                temp[idx++] = arr[right++];
//            }
//        }
//        
//        // 남은 부분 복사
//        while (left <= mid) {
//            temp[idx++] = arr[left++];
//        }
//        while (right <= end) {
//            temp[idx++] = arr[right++];
//        }
//        
//        for (int i = start; i <= end; i++) {
//            arr[i] = temp[i];
//        }
//    }
//}
import java.util.Scanner;

public class Solution {

	static int[] arr = new int[1000000];
	static int n = arr.length;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(0, n - 1);
		System.out.println(arr[n/2]);
	}

	static void quickSort(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);
			quickSort(start, pivot - 1);
			quickSort(pivot + 1, end);

		}
	}

	private static int partition(int start, int end) {
		// TODO Auto-generated method stub
		int pivot = arr[end];

		int i = start - 1;

		for (int j = start; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[end];
		arr[end] = temp;
		return i + 1;
	}
}
