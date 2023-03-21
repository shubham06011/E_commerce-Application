package com.e_commerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Admin_Operation {
	public static void getAdd_Product() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("ADD THE PRODUCTS INTO THE DATABASE ");
			
		System.out.println("ENTER THE ITEMS DESCRIPTION");
		String Description = scanner.nextLine();
		
		System.out.println("ENTER THE PRODUCT NAME");
		String Product_Name = scanner.nextLine();
		
		System.out.println("ENTER THE PRICE");
		float Price = scanner.nextFloat();
		
		System.out.println("ENTER THE QUANTITY");
		int Quantity = scanner.nextInt();
		getInsertData( Description, Product_Name, Price, Quantity);
		} 
		public static void getInsertData(String Description,String Product_Name,float Price,int Quantity) {
		
		try {
			Connection connection = CommonConnection.getConnection();

			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into electronic(Description,Product_Name,Price,Quantity)values(?,?,?,?)");

			
			preparedStatement.setString(1, Description);
			preparedStatement.setString(2, Product_Name);
			preparedStatement.setFloat(3, Price);
			preparedStatement.setInt(4, Quantity);
			preparedStatement.execute();
   
			System.out.println("Record inserted successfully..");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
		
		
		public static void getGenerate_Bill() {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("ENTER ID FOR GENERARING BILL");
			
			int Id = scanner.nextInt();	
			try {
				
				Connection connection = CommonConnection.getConnection();

				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from electronic where ID = ?");
				
				preparedStatement.setInt(1, Id);
				ResultSet rs = preparedStatement.executeQuery();
				if(rs.next()) {
					String obj = rs.getString("Product_Name");
					Float obj1 = rs.getFloat("Price");
					System.out.println("enter the Quantity");
					Float Quantity = scanner.nextFloat();
					Float total = Quantity * obj1;
					System.out.println("the amount for" +" " +Quantity +" " +obj +" " +"having price" +" " +obj1 +" " +"is" +" " +total);
					
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}}
			
			public static void getQuantity() {
				try {
					Scanner scanner = new Scanner(System.in);
					Connection connection = CommonConnection.getConnection();

					PreparedStatement preparedStatement = connection
							.prepareStatement("select Product_Name ,  Quantity from electronic Where Id =?");
                    System.out.println("ENTER THE Id");
                    int Id = scanner.nextInt();
					preparedStatement.setInt(1, Id);
					ResultSet resultSet=preparedStatement.executeQuery();
					
					while(resultSet.next()) {
						
						
						System.out.println("Product_Name>>" +resultSet.getString(1));
						System.out.println("Quantity>>" +resultSet.getFloat(2));
					
		   
					System.out.println();
					
				}} catch (SQLException e) {
					e.printStackTrace();
				}
        
		
		}
			public static void getUserRegistered_History() {
				try {
				Connection connection = CommonConnection.getConnection();

				PreparedStatement preparedStatement = connection
						.prepareStatement("select Id , FirstName , LastName from User_Registration  ");
				
				ResultSet resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next() ) {
					
					System.out.println("Id>>" +resultSet.getInt(1));
					System.out.println("FirstName>>" +resultSet.getString(2));
					System.out.println("LastName>>" +resultSet.getString(3));
					
				}} catch (SQLException e) {
					e.printStackTrace();
				}}}
			
				
			
		


