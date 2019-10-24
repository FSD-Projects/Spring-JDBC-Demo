package com.mycompany.spring_jdbc_di_demo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import com.mycompany.spring_jdbc_di_demo.model.Customer;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CustomerDAOImpl implements CustomerDAO {
	private DataSource dataSource = null;

	public void createCustomer(Customer c) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pStatement = connection.prepareStatement("INSERT INTO customer(name, email) VALUES(?, ?)");
			pStatement.setString(1, c.getEmail());
			pStatement.setString(2, c.getName());
			pStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void getCustomers() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * from customer");
			System.out.println("ID\tName\tEmail");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void deleteCustomer(int id) {
		
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			pStatement = connection.prepareStatement("DELETE FROM customer WHERE id =" + id);
			pStatement.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
