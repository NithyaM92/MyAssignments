package week3.day1;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "madam";
		String revStr = "";
	    char[] strArray = str.toCharArray();
	    for (int i = strArray.length-1 ; i >=0 ; i--) {
	    	revStr = revStr + strArray[i];
		
		} 
	   if (str.equalsIgnoreCase(revStr))
	   {
		   System.out.println("Given string " + str + " is palindrome");
	   }
	   else
	   { 
		   System.out.println("Given string " + str + " is not palindrome");  
	   }
		   
	}

}
