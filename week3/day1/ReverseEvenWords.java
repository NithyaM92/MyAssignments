package week3.day1;

	public class ReverseEvenWords {

	public static void main(String[] args) {
		String test = "I am a software tester"; 
		String[] splitTest = test.split(" ");
	    for (int i = 0; i < splitTest.length; i++) {
	    	System.out.print(" ");
			if(i%2==1)
			{
				char[] splitCharArray = splitTest[i].toCharArray();
				for (int j = splitCharArray.length-1; j>=0; j--) {
					System.out.print(splitCharArray[j]);
				}

			}
			else {
				System.out.print(splitTest[i]+ " ");
			}
		}	

	}

}
