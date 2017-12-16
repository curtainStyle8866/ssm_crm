package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.mapper.BaseDictMapper;
import com.itheima.pojo.BaseDict;
import com.itheima.service.BaseDictService;

@Service
public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictMapper baseDictMapper;
	@Override
	public List<BaseDict> getBaseDictList(String typeCode) {
		return baseDictMapper.getBaseDictList(typeCode);
	}

}
