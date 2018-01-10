package com.uanxon.dao;

import com.uanxon.model.BrwMessageLog;

public interface BrwMessageLogDAO {

/**
* 添加
* @param 
* @return
*/
public void insertBrwMessageLog(BrwMessageLog record);
/**
* 添加
* @param 
* @return
*/
public int updateByPrimaryKey(BrwMessageLog record);
/**
* 查询
* @param 
* @return
*/
public BrwMessageLog selectByPrimaryKey(Integer msgid);
}