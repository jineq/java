package kitaken_ex.java_konpe09_Arraylist;

import java.util.ArrayList;

public class onetoonehundred {
	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i += 2) {
			array.add(i);
		}
		System.out.print(array);
	}
}
