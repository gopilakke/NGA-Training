package com.example.map;

import java.util.HashMap;
import java.util.Map;

public class EmployeeMap {
	
	public static void main(String[] args) {
		
		Map<Integer, String> empMap = new HashMap<>();
		
		System.out.println(empMap.isEmpty());
		
	
		
		empMap.put(101, null);
		
		empMap.put(102, "Nitin");
		
		System.out.println("Total Employees are : " + empMap.size());
		
		System.out.println("Employee with Emp Id : 102 : " + empMap.get(102));
		
		System.out.println("Is employee id as 102 is present or not :" + empMap.containsKey(102));
		
		System.out.println("repalce the name Nitin to Jiya : " + empMap.replace(102,"Nitin","Jiya" ));
		
		System.out.println(empMap.remove(102));
		
		
	}
	
	
	

}
