package day2Assignment;

public class Calculator {
public void add(int num1,int num2) {
	System.out.println(num1=num2);
}
public void sub(float num1,int num2,int num3) {
	
	System.out.println(num1-num2+num3);
	
}
public static void main(String[] args) {
	Calculator cal=new Calculator();
	cal.add(6,7);
	cal.sub(7.8f,8,9);
	
}
}
