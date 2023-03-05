package week1.day1;

public class IsPrime {
public static void main(String[] args) {
	int number=57;
	int check=0;
		for (int i=2; i<=number/2 ; i++) {
			if (number%i==0)
			{
				System.out.println("The given number "+ number + " is non prime" );
				check=1;
				break;
			}
					
	}
		if(check==0)
		{
			System.out.println("The given number "+ number + " is prime" );
		}
}
}
