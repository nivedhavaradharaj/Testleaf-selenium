package Week1.day1;

public class mobile { 
	public void makeCall() {
		System.out.println("maka a call");
		String 	mobileModel = "iphone12";
		float mobileWeight = 180.8f;
		System.out.println("make a call to family");
	}
 public void sendmsg() {
	 boolean fullcharged = true;
	 int mobilecost = 75000;
	 System.out.println("sens a message to son");
	
	 
 }
public static void main(String[] args) {
	mobile obj = new mobile();
	obj.makeCall();
	obj.sendmsg();
	System.out.println("This is my phone");
 			
	
}
}
