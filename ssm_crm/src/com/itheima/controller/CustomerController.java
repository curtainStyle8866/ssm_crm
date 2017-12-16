package com.itheima.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.pojo.BaseDict;
import com.itheima.pojo.Customer;
import com.itheima.pojo.CustomerInfo;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;

@Controller
public class CustomerController {
	@Value("${customer.typecode.source}")
	private String customerSourceCode;
	@Value("${customer.typecode.industry}")
	private String customerIndustryCode;
	@Value("${customer.typecode.level}")
	private String customerLevelCode;
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("customer")
	public String getIndex(CustomerInfo info,Model model,@RequestParam(defaultValue="1")Integer page) throws Exception{
		//解决get方式提交的乱码
		/*String custName = info.getCustName();
		if(StringUtils.isNotBlank(custName)){
			custName = new String(custName.getBytes("iso-8859-1"),"utf-8");
			info.setCustName(custName);
		}*/
		//查询字典表，初始化查询条件
		List<BaseDict> sourceDictList = baseDictService.getBaseDictList(customerSourceCode);
		List<BaseDict> industryList = baseDictService.getBaseDictList(customerIndustryCode);
		List<BaseDict> levelList = baseDictService.getBaseDictList(customerLevelCode);
		model.addAttribute("fromType", sourceDictList);
		model.addAttribute("industryType",industryList);
		model.addAttribute("levelType", levelList);
		
		//查询客户列表
		Page<Customer> result = customerService.getCustList(info, page);
		//回显数据
		model.addAttribute("custName", info.getCustName());
		model.addAttribute("custSource", info.getCustSource());
		model.addAttribute("custIndustry", info.getCustIndustry());
		model.addAttribute("custLevel", info.getCustLevel());
		//把结果给jsp
		model.addAttribute("page", result);
		return "customer";
	}
	@RequestMapping("edit")
	@ResponseBody
	public Customer getCustomerById(long id){
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	@RequestMapping(value="update")
	@ResponseBody
	public String updateCustomerById(Customer customer){
		customerService.updateCustomerById(customer);
		//直接向浏览器响应字符串需要使用@ResponseBody
		return "success";
	}
	@RequestMapping("delete")
	@ResponseBody
	public String deleteCustomerById(long id){
		customerService.deleteCustomerById(id);
		return "success";
	}
}
