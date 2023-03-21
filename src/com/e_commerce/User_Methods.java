package com.e_commerce;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;



public class User_Methods {
	public static void getUser_Registration() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("***USER REGISTRATION***");
		try {
		
		
		System.out.println("Enter Your First Name:");
		String FirstName =scanner.next();
		
		System.out.println("Enter Your Last Name:");
		String LastName=scanner.next();
		
		System.out.println("Enter Your  UserName:");
		String UserName=scanner.next();
		
		System.out.println("Enter Your Password:");
		String Password=scanner.next();
		Connection conn = CommonConnection.getConnection();
        
		PreparedStatement prepare = conn.prepareStatement("INSERT INTO user_registration (FirstName,LastName,username, password) VALUES (?,?,?,? )");
     
        prepare.setString(1,FirstName);
        prepare.setString(2,LastName);
        prepare.setString(3,UserName);
        prepare.setString(4,Password);
        prepare.execute();
		System.out.println("THANK YOU" +" " +FirstName  +" " +"YOUR ACCOUNT HAS BEEN CREATED");
		
		
		
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	}
	
	
		public static void  getUser_Login() {
			try {
				
				Scanner scanner = new Scanner(System.in);
		System.out.println("***USER LOGIN***");
		
		
		System.out.println("Enter Your  UserName:");
		String UserName=scanner.next();
		
		System.out.println("Enter Your Password:");
		String Password=scanner.next();
		
		
			Connection connection=CommonConnection.getConnection();
			Statement statement = connection.createStatement();
			String string =" select * from user_registration where UserName = '"+ UserName +"' AND Password = '" + Password +"'";
			ResultSet rs = statement.executeQuery(string);
			if(rs.next()) {
				System.out.println("LOGIN SUCCESSFULL");
				System.out.println("TYPE YES TO VIEW ITEM LIST ");
				String choice = scanner.next();
				String obj= choice.toLowerCase();
				if(choice.equalsIgnoreCase("yes")) {
				User_Methods.getProduct_list();
				User_Methods.getBuy_Product();
				User_Methods.getView_Cart();
				}
			}
			else {
				System.out.println("INVALID INFORMATION");
			    
			}
		}
		 catch (Exception ex) {
	        	      System.out.println("Error: " + ex);
	        	    
	        	    }
	        	  
		}
	      
	
	public static void getProduct_list() {
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from ELECTRONIC");
			
			
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				System.out.println("ID: " +resultSet.getInt(1));
				System.out.println("DESCRIPTION: " +resultSet.getString(2));
				System.out.println("PRODUCT_NAME: " +resultSet.getString(3));
				System.out.println("PRICE: " +resultSet.getString(4));
				System.out.println("QUANTITY: " +resultSet.getInt(5));
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	public static void getBuy_Product() {
		Scanner scanner = new Scanner(System.in);
		
		
		
		System.out.println("Enter The Product Id To Buy Product: ");
		int Id = scanner.nextInt();
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("select * from ELECTRONIC where id=?");
			
			preparedStatement.setInt(1,Id);
			
			ResultSet resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				
				System.out.println("Id>>" +resultSet.getInt(1));
				System.out.println("Description>>" +resultSet.getString(2));
				System.out.println("Name>>" +resultSet.getString(3));
				System.out.println("Price>>" +resultSet.getString(4));
				System.out.println("Quantity>>" +resultSet.getInt(5));
				
				
			}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}}
		
	
	
	public static void getView_Cart() {
		Scanner scanner = new Scanner(System.in);
		
		try {
			Connection connection=CommonConnection.getConnection();
			
			PreparedStatement preparedStatement=connection.prepareStatement("insert into add_cart(Id,price,quantity) values (?,?,?)");
			
			System.out.println("CONFORM YOUR ID");
			int Id = scanner.nextInt();
			
			System.out.println("ENTER THE QUANTITY");
			float quantity = scanner.nextFloat();
			
			System.out.println("Enter the Price");
			float Price = scanner.nextFloat();
			
			 preparedStatement.setInt(1,Id);
			 preparedStatement.setFloat(2,quantity);
			 preparedStatement.setFloat(3,Price);
			
			 preparedStatement.execute();
			 System.out.println("PRODUCT ITEMS HAS BEEN ADDED TO CART");
			 try {System.out.println("ENTER ID FOR CONFORMING THE ORDER");
									
					Connection con = CommonConnection.getConnection();

					PreparedStatement prepared = connection
							.prepareStatement("select * from electronic where Id = ?");
					
					prepared.setInt(1,scanner.nextInt());
					ResultSet rs1 = prepared.executeQuery();
					if(rs1.next()) {
						String obj = rs1.getString("Product_Name");
						Float obj1 = rs1.getFloat("Price");
						
						Float total = quantity * obj1;
						System.out.println("the amount for" +" " +quantity +" " +obj +" " +"having price" +" " +obj1 +" " +"is" +" " +total);
						
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}}
		
    public static void getUser_operation(){
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
}
	
	
	
	
	

