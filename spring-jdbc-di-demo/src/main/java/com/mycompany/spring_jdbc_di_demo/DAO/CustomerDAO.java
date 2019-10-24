package com.mycompany.spring_jdbc_di_demo.DAO;

import com.mycompany.spring_jdbc_di_demo.model.Customer;

public interface CustomerDAO {
	public void createCustomer(Customer c);
	public void getCustomers();
	public void deleteCustomer(int id);
}
