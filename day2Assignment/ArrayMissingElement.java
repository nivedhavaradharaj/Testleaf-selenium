package day2Assignment;

import java.util.Arrays;

public class ArrayMissingElement {

	public static void main(String[] args) {
		int[] num = {1,2,3,4,7,6,8};
		Arrays.sort(num);
		System.out.println(Arrays.toString (num));
		for(int M = 0;M < num.length;M++) {
			if(num[M]+1 != num[M+1])
			{
				System.out.println(num[M]+1);
			break;
		         
		
			}
	}
	}
	}

