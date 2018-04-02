package com.jsjf.dao.member;

import com.jsjf.model.member.JsMemberIntegralRecord;

public interface JsMemberIntegralRecordDAO {
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
	public int insert(JsMemberIntegralRecord obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(JsMemberIntegralRecord obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public JsMemberIntegralRecord selectByPrimaryKey(Integer id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(JsMemberIntegralRecord obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(JsMemberIntegralRecord record);
	  
}