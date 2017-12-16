package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;

public interface CustomerMapper {
	List<Customer> getCustList(CustomerInfo info);
	int getCustListCount(CustomerInfo info);
	Customer getCustomerById(long id);
	void updateCustomerById(Customer customer);
	void deleteCustomerById(long id);
}
