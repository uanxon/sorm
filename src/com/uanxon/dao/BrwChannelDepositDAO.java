package com.uanxon.dao;

import com.uanxon.model.BrwChannelDeposit;

public interface BrwChannelDepositDAO {

/**
* 添加
* @param 
* @return
*/
public void insertBrwChannelDeposit(BrwChannelDeposit record);
/**
* 添加
* @param 
* @return
*/
public int updateByPrimaryKey(BrwChannelDeposit record);
/**
* 查询
* @param 
* @return
*/
public BrwChannelDeposit selectByPrimaryKey(Integer id);
}