package week3.day1;

public class MyPhone extends IPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IPhone phone = new IPhone();
		phone.startApp();
		/*phone.increaseVolume();
		phone.shutDown();
		phone.makeCall();
		phone.sendSMS(); */
		IOS ios = new IOS(); 
		ios.startApp();

	}

}
