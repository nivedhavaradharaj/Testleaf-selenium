package day2Assignment;

import java.util.Arrays;

public class ArraySmallerNumber {
	public static void main(String[] args)
	{
		int num[]= {23,45,67,32,89,22};
		Arrays.sort(num);
		System.out.println("The smallest number of the array is:" + num[1]);
		
	}

}

