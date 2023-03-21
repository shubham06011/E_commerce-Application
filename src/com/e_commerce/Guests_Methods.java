package com.e_commerce;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guests_Methods {
	public static void getShowProduct_List() {
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
	
	
public static void main(String[] args) {
	getShowProduct_List();
}}
