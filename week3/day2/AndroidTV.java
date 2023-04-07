package week3.day2;

public abstract class AndroidTV implements Android{
	
	 public void openApp() {
		System.out.println("AndroidTV openAPP print statement from Interface");
		
	}
	public abstract void screen();
	
	public void rechargePlan() {
		// TODO Auto-generated method stub
		System.out.println("Rechargeplan statement inside Abstract class AndroidTV");

	}
}
