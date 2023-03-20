package week3.day1;

public class Calculator {
       public void addNumbers(int a , int b ) {
		// TODO Auto-generated method stub 
    	   System.out.println(a+b);

	}
     public void addNumbers(int a, int b, int c) {
		// TODO Auto-generated method stub
            System.out.println(a+b+c);
	}
   /*   public int addNumbers(int a, int b) {
		// TODO Auto-generated method stub
         return a+b;
	} */
     
     public void multipleNumbers(double a , double b) {
		// TODO Auto-generated method stub
    	 System.out.println(a*b);

	}
     public void multipleNumbers (double a, int b)
     {
    	 System.out.println(a*b);
     }
     
     public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.addNumbers(10, 98);
		calc.addNumbers(98, 99, 112);
		calc.multipleNumbers(100, 989);
		calc.multipleNumbers(11, 88);
	}

}
