package day2Assignment;

public class ArrayAssignment5FindIntersection {
	public static void main(String[] args) {
		int sec1[]={3,2,11,4,6,7};
		int sec2[]={1,2,8,4,9,7};
		for (int m = 0; m<sec1.length;m++)
			for(int n=0;n<sec2.length;n++)
			{
				if (sec1[m]==sec2[n])
					System.out.println(sec2[n]);
			}

	}

}	 
	
	
	 


	



