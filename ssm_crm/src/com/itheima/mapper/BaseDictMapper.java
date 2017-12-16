package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.BaseDict;


public interface BaseDictMapper {
	List<BaseDict> getBaseDictList(String typeCode);
}
