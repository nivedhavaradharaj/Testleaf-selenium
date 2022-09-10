package day2Assignment;

public class ArrayFibonacSeries {
	public static void main(String[] args)
	{
		int range=8;
		int num1=0;
		int num2=1;
		int sum;
		System.out.println(num1);
		System.out.println(num2);
		for(int i=1;i<=range-2;i++)
		{
			sum=num1+num2;
			num1=num2;
			num2=sum;
			System.out.println(sum);
		}

	

}
}
