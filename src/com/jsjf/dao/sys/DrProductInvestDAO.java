package com.jsjf.dao.sys;

import com.jsjf.model.sys.DrProductInvest;

public interface DrProductInvestDAO {
	/**
	 * delete
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id);
	/**
	 * insert 所有属性
	 * @param record
	 * @return
	 */
	public int insert(DrProductInvest obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(DrProductInvest obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public DrProductInvest selectByPrimaryKey(Integer id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(DrProductInvest obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(DrProductInvest record);
	  
}