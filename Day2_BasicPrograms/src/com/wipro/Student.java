package com.wipro;



public class Student {
	
	
	int id ;
	String name;
	int[] marks;
	// int[][] marks = null;
	
		public Student() {
		
		// TODO Auto-generated constructor stub
	}

	//Constructor
	public Student(int id, String name, int[] marks) {
		
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public void displayInfo()
	{
		System.out.println("Student Id :" + id);
		System.out.println("Student Name :" + name);
		System.out.println("Student Marks :" );
		for(int mark : marks)
		{
			System.out.print(mark + " ");
		}
		System.out.println("\n..");
		
		
	}


	
}
