package com.uanxon.dao;

import com.uanxon.model.BrwMemberMsg;

public interface BrwMemberMsgDAO {

/**
* 添加
* @param 
* @return
*/
public void insertBrwMemberMsg(BrwMemberMsg record);
/**
* 添加
* @param 
* @return
*/
public int updateByPrimaryKey(BrwMemberMsg record);
/**
* 查询
* @param 
* @return
*/
public BrwMemberMsg selectByPrimaryKey(Integer id);
}