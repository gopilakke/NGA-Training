package com.example.oops;

import java.util.Scanner;

// E-commerce  -- users are paying using either credit card  ,  cod  ,  upi(Google Pay , PhonePe etc.)
// vendor specific implementation --  Abstract or Interface -- Abstraction
// Payment processing -- polymorphism
// user id  , password  , roles  -- Encapsulation(Data Validations)

// So payment class in which we have a paymentProcessing method which is common for all the vendors

//Base/Parent/Super Class which Amazon has created 
 class PaymentMethod
{
	 
	 void input()
	 {
	 int i=0;
	 for(; ;i++)
	 {
		 
		 
	 }
	 }
	 // Example of Overloading
	public void processPayment(double amount)
	{
		System.out.println("Processing payment is done of Rs. " + amount);
	}
	
	public void processPayment(int amount , int gstNumber)
	{
		System.out.println("Processing payment is done of Rs. " + amount);
	}
}

 // Child/Sub/Derived Class overriding the processPayment Method
class Zara extends PaymentMethod
{
	

	class CreditCard extends PaymentMethod
	{
		
		public void processPayment(double amount)
		{

		System.out.println("Payment is done via Credit Card :");
		}
		
	}
	
	class Upi extends PaymentMethod
	{
		
		public void processPayment(double amount)
		{
			System.out.println("Payment is done via Upi :");
		}
		
	}



}
 

// Child/Sub/Derived Class
class Nike extends PaymentMethod
{
	
	class CreditCard extends PaymentMethod
	{
		
		
		
		public void processPayment(double amount )
		{
			System.out.println("Payment is done via Credit Card without GST :");
		}
		
		
	}
	
	class Upi extends PaymentMethod
	{
		
		public void processPayment(double amount , int gstNumber)
		{
			System.out.println("Payment is done via Upi  :");
		}
		
	}



}
 
public class PolymorphismExample {
	
	public static void main(String[] args)
	
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Select you would like to make payment with 1. Zara or 1. Nike 3. exit");
		
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
		Zara zara = new Zara();
        Zara.CreditCard cc = zara.new CreditCard(); 
        cc.processPayment(1000);
        
        Zara.Upi upi = zara.new Upi();
        upi.processPayment(500);
		break;
		case 2:
		Nike nike = new Nike();
        Nike.CreditCard cc1 = nike.new CreditCard(); 
        cc1.processPayment(6000,346657);

        Nike.Upi upi1 = nike.new Upi();
        upi1.processPayment(700,678687);
		break;
		case 3:
			sc.close();
        
		}
//		PaymentMethod p = z.new CreditCard();
//		p.processPayment(10000);
//		PaymentMethod p1 = z.new Upi();
//		p1.processPayment(600);
		
		
	}
	


}
