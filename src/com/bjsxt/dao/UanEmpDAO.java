package com.bjsxt.dao;

import com.bjsxt.po.UanEmp;

public interface UanEmpDAO {

/**
* 添加
* @param 
* @return
*/
public void insertUanEmp(UanEmp record);
/**
* 添加
* @param 
* @return
*/
public int updateByPrimaryKey(UanEmp record);
/**
* 查询
* @param 
* @return
*/
public UanEmp selectByPrimaryKey(Integer id);
}