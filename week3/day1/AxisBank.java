package week3.day1;

public class AxisBank extends BankInfo {

	@Override
	public void deposit() {
		// TODO Auto-generated method stub
		System.out.println("Deposit Account interest Rate - 9%");
	}
	public static void main(String[] args) {
		AxisBank axis = new AxisBank();
		axis.deposit();
		axis.saving();
		axis.fixed();
		
		BankInfo bank =  new BankInfo();
		bank.deposit();
	}
}
