package com.uanxon.dao;

import com.uanxon.model.DrClaimsLoan;

public interface DrClaimsLoanDAO {

/**
* 添加
* @param 
* @return
*/
public void insertDrClaimsLoan(DrClaimsLoan record);
/**
* 添加
* @param 
* @return
*/
public int updateByPrimaryKey(DrClaimsLoan record);
/**
* 查询
* @param 
* @return
*/
public DrClaimsLoan selectByPrimaryKey(Integer id);
}