package com.itheima.service;

import java.util.List;

import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;
import com.itheima.utils.Page;

public interface CustomerService {
	
	Page<Customer> getCustList(CustomerInfo info,int currentPage);
	Customer getCustomerById(long id);
	void updateCustomerById(Customer customer);
	void deleteCustomerById(long id);
}
