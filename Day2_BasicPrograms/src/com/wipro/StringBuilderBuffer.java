package com.wipro;

import java.lang.System;

public class StringBuilderBuffer {
	
	// asynchronous / synchronous StringBuffer - It's synchronized and it's a thread safe
	public static void main(String[] args) {
		
	//	String cname = "Wipro";
	//	cname = cname + "Ltd"; // create  a new object ,, the original wipro 
		
		long start ,end;
		start = System.currentTimeMillis();
		String s = "";
		
		for(int i=0 ; i<500 ; i++)
		{
			
			s+="Some";
			System.out.println(System.identityHashCode(s));
		}
		end = System.currentTimeMillis();
		System.out.println("Total time taken using String " + (end-start));
		
		//String builder is mutable and fast --- It's not a thread safe
		//Efficient in appending to the same location and no new object will be created  
		start = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for(int i=0 ; i<500 ; i++)
		{
			
			sb.append("Some");
			System.out.println(System.identityHashCode(sb));
		}
		end = System.currentTimeMillis();
		System.out.println("Total time taken using String Builder " + (end-start));
		
		
		//String Buffer is mutable but slow because of synchronization
		start = System.currentTimeMillis();
		StringBuffer sbuffer = new StringBuffer();
		for(int i=0 ; i<500 ; i++)
		{
			
			sbuffer.append("Some");
			System.out.println(System.identityHashCode(sbuffer));
		}
		end = System.currentTimeMillis();
		System.out.println("Total time taken using String Buffer " + (end-start));
		
		
		
		
	}
	

}

/*Activity
 * Create an employee class (id,name ,position and salary) then create an array of employee objects and then
 * create a menu driven program  to add , view, search by name(where string contains , ignore case),
 * Update employee by ID , delete employee by ID and then exit
 * 
 * also use some of string operations like .equalsIngnoreCase , .contains , .toLowerCase for search and .trim for input cleaning.
 * 
 * 
 * */


//public class Employee
//{
//	
//attribute
//	
// methods
//	
//add()
//view()
//	
//
//}
//
//class EmployeeManagement
//{
//	Employee e  = null;
//	while(true)
//	{
//sysout ("Employee Management")
//sysout("1. add");
//int choice = sc.nextInt();
//switch(choice)
//{
//case 1:
//	 e = new Employee();
//	e.add();
//case 2:
//	
//
//}
//
//
//}
//
//
//}




















