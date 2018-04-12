package com.jsjf.dao.commodity;

import com.jsjf.model.commodity.JsCommodityImages;

public interface JsCommodityImagesDAO {
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
	public int insert(JsCommodityImages obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(JsCommodityImages obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public JsCommodityImages selectByPrimaryKey(Integer id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(JsCommodityImages obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(JsCommodityImages record);
	  
}