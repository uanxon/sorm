package com.jsjf.dao.commodity;

import com.jsjf.model.commodity.JsCommodity;

public interface JsCommodityDAO {
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
	public int insert(JsCommodity obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(JsCommodity obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public JsCommodity selectByPrimaryKey(Integer id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(JsCommodity obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(JsCommodity record);
	  
}