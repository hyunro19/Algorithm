package jv.bj.lv2;

import java.util.Scanner;

public class N1085_EscapeFromARectangular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nextLine = sc.nextLine();
		String[] xywh = nextLine.split(" ");
		
		int x = Integer.parseInt(xywh[0]);
		int y = Integer.parseInt(xywh[1]);
		int w = Integer.parseInt(xywh[2]);
		int h = Integer.parseInt(xywh[3]);
		
		int verticalMin = Math.min(w-x, x);
		int horizontalMin = Math.min(h-y, y);
		int min = Math.min(verticalMin, horizontalMin);
		
		System.out.println(min);
	}

}
