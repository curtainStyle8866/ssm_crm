package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.CustomerMapper;
import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Page<Customer> getCustList(CustomerInfo info,int currentPage) {
		info.setStartIndex((currentPage-1)*info.getPageSize());
		Page<Customer> page=new Page<>();
		page.setRows(customerMapper.getCustList(info));
		page.setTotal(customerMapper.getCustListCount(info));
		page.setPage(currentPage);
		page.setSize(info.getPageSize());
		return page;
	}

	@Override
	public Customer getCustomerById(long id) {
		return customerMapper.getCustomerById(id);
		 
	}

	@Override
	public void updateCustomerById(Customer customer) {
		customerMapper.updateCustomerById(customer);
		
	}

	@Override
	public void deleteCustomerById(long id) {
		customerMapper.deleteCustomerById(id);
	}

}
