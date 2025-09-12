package com.wipro;


//local variable , instance variable,static variable (Method Area), final variables(Varies)

// variables are named one and act as a container for storing data , They must be declared with a type
 class VariablesStructure {
	
	// Non-static or Instance variables -- these are stored in heap
	int id =101;
	String designation="Trainer";
	
	//Stored with object data so it is a part of heap and stored in heap only
	final double price= 45.67; 
	
	//Static variable memory allocation will be once and also the same will be shared by all objects.
	//Method area (Meta Space)  where class definitions , static variables , method info
	static int count=10;
	
	int countVar = 10;
	
	

	//local variable as inside a method or a block
	// Local variables memory will be stored in stack  -- temporary stored
//	public static void main(String[] args)
//	{
//		
//		int a =10;
//	}
	
	
	//Method
	public void Input()
	{
		
		
		
		
		int age =30;
		String name = "Jiya";
		
		// stored in Method Area
		final double cost=56.90; 
		
	}
	
	//Block
	static
	{
		
		
		// final variables cannot be changed 
		//Stored in a constant pool
		final int b =20; //  can't be reassigned and stored in a stack(Local context)
		System.out.println("From static block:" + b);
		
		
	}
	

}
 
 public class VariablesInJava
 {
	 static int staticCount = 0; // Method Area
	 final double pi =3.14 ; // Heap (final instance variable)
	 String name ; //Heap
	 
	 
	 public void Input1()
	 {
		 
		 int localVar = 300; // stack
		 final int localConst = 200; // stack
		 
		 System.out.println(localVar + " " + localConst);
		 // you can access without an object reference and if you are calling in same class
		// System.out.println(count);
		 System.out.println(staticCount);
	 }
	 
	 public static void main(String[] ar)
	 {
		 // Object is in Heap & reference variables is in stack
		 VariablesInJava vij = new VariablesInJava();
		 System.out.println(vij.pi);
		 vij.Input1();
		 System.out.println(vij.staticCount);
		
		 VariablesInJava vij2 = new VariablesInJava();
		 System.out.println(vij2.staticCount);

		
		 
		 
		 VariablesStructure vs = new VariablesStructure();
		 System.out.println("Variables Structure Class Object 1");
		 System.out.println(vs.count); 
		 
		 
		 
	 
 
 }
 }

 
 /*rule says 
  * 1. the class name where your main function is it should be the public 
  * and filename should also be the same
  * 2. Class name  - should be the pascal case
  * 3. Methods name and variable names  -- should be in camel case
  * 4. package name -- all are in small where it contains your domain name for eg: com.wipro after which 
  * we would create subpackages as well.
  * 5. variable name should starts with underscore, Dollar or with characters not a number or any other specialcharacters
  * 6. Literal are the meaningful name you provide to a class , variables , methods
  */
  
 

