// 문제: 백준 28279 덱 2
// 링크: https://www.acmicpc.net/problem/28279
// 시간: 000ms

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		sc.nextLine();
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=0;i<n;i++) {
			String str = sc.nextLine();
			String[] arr = str.split(" ");
			int a = Integer.parseInt(arr[0]);
			switch (a) {
			case 1:
				int num = Integer.parseInt(arr[1]);
				deque.addFirst(num);
				break;
			case 2:
				int b_num = Integer.parseInt(arr[1]);
				deque.addLast(b_num);
				break;
			case 3:
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
					sb.append(deque.pollFirst()).append("\n");
					break;
				}
			case 4:
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
					sb.append(deque.pollLast()).append("\n");
					break;
				}
			case 5:
				sb.append(deque.size()).append("\n");
				break;
			case 6:
				if(deque.isEmpty()) {
					sb.append(1).append("\n");
					break;
				}else {
					sb.append(0).append("\n");
					break;
				}
			case 7:
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");					
					break;
				}else {
					sb.append(deque.peekFirst()).append("\n");
					break;
				}
			case 8:
				if(deque.isEmpty()) {
					sb.append(-1).append("\n");
					break;
				}else {
					sb.append(deque.peekLast()).append("\n");
					break;
				}
			}
		}
		System.out.print(sb);
	}
}