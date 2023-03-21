package com.e_commerce;

import java.util.Scanner;

public class UsreOperation {
	public static void getUserInputs() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***WELCOME TO E-COMMERCE APPLICATION***");
		
		System.out.println();
		System.out.println("   Enter 1.User\n   Enter 2.Admin\n   Enter 3.Guest\n");
		int input= scanner.nextInt();
		if(input==1) {
			User_Methods.getUser_operation();
			System.out.println();
			System.out.println();
			
		}
		else if(input==2) {
			System.out.println("  1.ADDING PRODUCT \n  2.GENERATING BILL \n  3.CHECK QUANTITY  \n  4.REGISTRATION HISTORY");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
			Admin_Operation.getAdd_Product();
			break;
			case 2:
			Admin_Operation.getGenerate_Bill();
			break;
			case 3:
			Admin_Operation.getQuantity();
			break;
			case 4:
			Admin_Operation.getUserRegistered_History();
			break;
			}}
		else if(input==3) {
			System.out.println("ENTER YES TO SEE PRODUCT LIST");
			String choice = scanner.next();
			String obj= choice.toLowerCase();
			if(choice.equalsIgnoreCase("yes")) {
			Guests_Methods.getShowProduct_List();
		}}
		else  {
			
		System.out.println("Invalid User");	
		}
			
	}}
	
	/*public static void getUser_operation(){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. User Registration\r\n" + 
				           "2. User Login\r\n"
				            );
		System.out.println();
		System.out.println("Enter Your Choice:");
		int Choice = scanner.nextInt();
		if(Choice==1) {
			User_Methods.getUser_Registration();
			System.out.println("TYPE YES TO VIEW ITEM LIST ");
			String choice = scanner.next();
			
			if(choice.equalsIgnoreCase("yes")) {
			User_Methods.getProduct_list();
			User_Methods.getBuy_Product();
			User_Methods.getView_Cart();
			}}
			else if (Choice==2)  {
				User_Methods.getUser_Login();
			}
			else {
				System.out.println("exit");
			}
			}
}*/
		
		
		
		
		
	
 