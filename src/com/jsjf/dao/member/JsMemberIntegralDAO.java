package com.jsjf.dao.member;

import com.jsjf.model.member.JsMemberIntegral;

public interface JsMemberIntegralDAO {
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
	public int insert(JsMemberIntegral obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(JsMemberIntegral obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public JsMemberIntegral selectByPrimaryKey(Integer id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(JsMemberIntegral obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(JsMemberIntegral record);
	  
}