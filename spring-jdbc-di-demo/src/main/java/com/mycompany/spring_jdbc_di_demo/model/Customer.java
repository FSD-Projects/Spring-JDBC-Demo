package com.mycompany.spring_jdbc_di_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Customer {
	public Customer(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public int id;
	public String name;
	public String email;
}
