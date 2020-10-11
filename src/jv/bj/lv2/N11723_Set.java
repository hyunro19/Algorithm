package jv.bj.lv2;

import java.util.*;

public class N11723_Set {

	public static void main(String[] args) {
		// 1. 범위가 정해져 있으므로 set보다 그냥 배열을 쓰는게 낫다.
		// 2. 출력도 매번 하는 것 보다 StringBuilder에 모아두었다가 한 번에 하는게 시간효율이 좋다.
		// 3. Arrays.fill이 for문 반복보다 효율이 좋다.
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int nextInt = Integer.parseInt(sc.nextLine());
		boolean[] arr = new boolean[21];
		for(int i=0; i<nextInt; i++) {
			String nextLine = sc.nextLine();
			String[] split = nextLine.split(" ");
			String command = split[0];
			
			if(command.equals("add")) {
				int operand = Integer.parseInt(split[1]);
				arr[operand] = true;
			} else if (command.equals("remove")) {
				int operand = Integer.parseInt(split[1]);
				arr[operand] = false;
			} else if (command.equals("check")) {
				int operand = Integer.parseInt(split[1]);
				if(arr[operand]) sb.append("1\n");
				else sb.append("0\n");
			} else if (command.equals("toggle")) {
				int operand = Integer.parseInt(split[1]);
				arr[operand] = !arr[operand];
			} else if (command.equals("all")) {
				Arrays.fill(arr, true); // Arrays.fill이 for문 보다 효율이 좋네
			} else if (command.equals("empty")) {
				Arrays.fill(arr, false);
			}
			
		}
		System.out.println(sb);
		sc.close();
	}

}
