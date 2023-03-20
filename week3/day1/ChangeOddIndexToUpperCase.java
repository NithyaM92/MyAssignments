package week3.day1;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "changeme";
		System.out.println("Current text is : " + test);
		char[] chArray = test.toCharArray();
		for (int i = 0; i < chArray.length; i++) {
			if(i%2==1) {
				chArray[i] = Character.toUpperCase(chArray[i]);
			}
			
		}
		// System.out.println("Updated text is : "+ chArray);
		System.out.print("Updated text is : " );
		
		for (int i = 0; i < chArray.length; i++) {
			System.out.print(chArray[i]);
		}

	}

}
