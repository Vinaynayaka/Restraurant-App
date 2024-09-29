package com.restauranapp;

import java.util.Scanner;

class MenuItem{
	private String itemName;
	private double itemPrice;
	MenuItem(String itemNames,double itemPrices)
	{
		itemName=itemNames;
		itemPrice=itemPrices;
	}
	String getItemName() 
	{
		return itemName;
	}
	double getItemPrice() 
	{
		return itemPrice;
	}
	public String toString()
	{
		return itemName+"\n  Price="+itemPrice;
	}
}
class Order
{
	MenuItem items[];
	int plates[];
	int itemCount;
	double bill=0;
	Order(int initialSize)
	{
		items=new MenuItem[initialSize];
		plates=new int[initialSize];
	}
	void addItem(MenuItem item,int num)
	{
		if(items.length==itemCount)
		{
			System.out.println("Order List is Full");
		}
		else
		{
			items[itemCount]=item;
			plates[itemCount]=num;
			itemCount++;
			System.out.println("Item Added...");
			
		}
	}
	void calculateBill(MenuItem item,int num)
	{
		bill=bill+(item.getItemPrice()*num);
	}
	void displayOrderedItems()
	{
		if(itemCount==0)
			System.out.println("No Ordered Items");
		else
		{
			System.out.println("You Ordered");
			for(int i=0;i<itemCount;i++)
			{
				System.out.println(items[i]+"\nQuantity: "+plates[i]+"-Plates");
			}
		}
	}
	void displayBill()
	{   double total=bill;
		if(bill>=1000) 
		{
			double discAmount=bill*10/100;
			total=bill-discAmount;
			System.out.println(".........Welcome to Mehfil........");
			System.out.println("Total Amount="+bill);
			System.out.println("Discount Amount="+discAmount);
			System.out.println("Amount to Pay="+total);
			System.out.println(".........Thank You For Visiting...........");
			System.out.println("................................Come Again");
		}
		else 
		{
			System.out.println(".........Welcome to Mehfil........");
			System.out.println("Total Amount="+bill);
			//System.out.println("Amount to Pay="+total);
			System.out.println(".........Thank You For Visiting...........");
			System.out.println("................................Come Again");
		}

	}
}

public class RestaurantApp 
{
	static  MenuItem items[];
	static void initializeMenu()
	{
		items=new MenuItem[10];
		items[0]=new MenuItem("Single Chicken Biryani",140);
		items[1]=new MenuItem("Chicken Biryani Family",550);
		items[2]=new MenuItem("Single Mutton Biryani",240);
		items[3]=new MenuItem("Mutton Biryani Family",700);
		items[4]=new MenuItem("Dessert",200);
		
	}
	static void displayMenu()
	{ 
		
		for(int i=0;i<items.length;i++)
		{
			if(items[i]!=null)
				System.out.println((i+1)+"."+items[i]);
		}
	}
	public static void main(String[] args) 
	{
		initializeMenu();
		boolean isExit=false;
		Scanner sc=new Scanner(System.in);
		Order o1=new Order(5);
		while(!isExit)
		{
			System.out.println("1.Display Menu");
			System.out.println("2.Ordet An Item");
			System.out.println("3.Display Ordered Items");
			System.out.println("4.Calculate Bill");
			System.out.println("5.Exit...");
			int n=sc.nextInt();
			switch(n)
			{
				case 1: displayMenu();
						break;
				case 2: System.out.println("Enter Item Id");
						int id=sc.nextInt();
						System.out.println("Enter Number of Plates");
						int num=sc.nextInt();
						o1.addItem(items[id-1],num);
						o1.calculateBill(items[id-1],num);
						break;
				case 3: o1.displayOrderedItems();
						break;
				case 4: o1.displayBill();
						break;
				case 5: isExit=true;
						break;
				default: System.out.println("Invalid Option");
			}
		}
	}
}
