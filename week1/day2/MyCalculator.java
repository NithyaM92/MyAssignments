package week1.day2;

public class MyCalculator {

	public static void main(String[] args) {
	
		Calculator objCalculator = new Calculator ();
		System.out.println("Sum is : " + objCalculator.addNumbers(80, 90, 100));
		System.out.println("Multiplication result is : " + objCalculator.mulNumbers(66,78));
		objCalculator.sub();

	}

}
