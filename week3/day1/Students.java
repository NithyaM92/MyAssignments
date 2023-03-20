package week3.day1;

public class Students {
	
	public void getStudentInfo(int id) {
		// TODO Auto-generated method stub
		System.out.println("Student name is : Nithya M and ID is: "+ id);

	}
	 public void getStudentInfo(int id, String name) {
		// TODO Auto-generated method stub
		 System.out.println("Student ID is : " + id + " and name is: "+name);

	}
	 public void getStudentInfo(String email, String phone) {
		 System.out.println("Student email is : " + email + "and phone number is :" + phone);
		 
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Students stu = new Students();
		stu.getStudentInfo(32);
		stu.getStudentInfo(32, "Nithya M");
		stu.getStudentInfo("test_first@gamil.com", "9876543210");

	}

}
