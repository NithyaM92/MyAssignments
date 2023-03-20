package org.student;

import org.department.Department;

public class Student extends Department {

	public void studentName() {
		// TODO Auto-generated method stub

		System.out.println("Student name is Nithya M");
	}
	public void studentDept() {
		// TODO Auto-generated method stub
		System.out.println("Student department is CSE");

	}
	public void studentId() {
		// TODO Auto-generated method stub
		System.out.println("Student ID is : 20092032");

	}
	public static void main(String[] args) {
		Student stu = new Student();
		stu.collegeName();
		stu.collegeCode();
		stu.collegeRank();
		stu.deptName();
		stu.studentName();
		stu.studentDept();
		stu.studentId();
	}
}
