package week3.day2;

public class Automation extends MultipleLangauge implements Language,TestTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Automation aut = new Automation();
		aut.ruby();
		aut.python();
		aut.selenium();
		aut.java();	

	}

	public void selenium() {
		// TODO Auto-generated method stub
		System.out.println("Selenium method in TestTool interface");
		
	}

	public void java() {
		// TODO Auto-generated method stub
		System.out.println("Java method inside Language interface");
		
	}

	@Override
	public void ruby() {
		// TODO Auto-generated method stub
		System.out.println("ruby method inside MultipleLangauge abstract class");
		
	}

}
