package com.wipro;

class Studentss
{
	int id;
	String name;

	
	Studentss[] sArray = new Studentss[10];

}

public class ArraysExample {
	
	//Types of Arrays
	
	//Single Dimensional  , // Multi Dimensional , // Jagged Array
	
	
	public static void main(String[] arrays)
	{
		
//	int[4] students;
	//students = new int[4];
		
		
		  int size =4;
		int[] students = new int[size];	
			 	
			System.out.println(students.length);
			
			students[0] = 101;
			students[1] = 102;
			students[2] = 103;
			students[3] = 104;
			
			System.out.println("The array element at a particular index no i.e.3 : " + students[2]);
	
//			for(int i=0 ; i<students.length ; i++)
//			{
//				System.out.println(students[i]);
//				
//			}
			
			//Enhanced for loop for an array we can use
		for(int itr : students)
		{
			System.out.println(itr);
			
		}
	}

}





//Create an  student class which will store the elements in an object i.e. id and name is of primitive type 
// and marks is in array 



