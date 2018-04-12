package com.jsjf.dao.commodity;

import com.jsjf.model.commodity.JsCommodityOrder;

public interface JsCommodityOrderDAO {
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
	public int insert(JsCommodityOrder obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(JsCommodityOrder obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public JsCommodityOrder selectByPrimaryKey(Integer id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(JsCommodityOrder obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(JsCommodityOrder record);
	  
}