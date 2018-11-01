package com.jyjf.admin.dao.sysadmin;

import com.jyjf.admin.model.sysadmin.SysDept;

public interface SysDeptDAO {
	/**
	 * delete
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer dept_id);
	/**
	 * insert 所有属性
	 * @param record
	 * @return
	 */
	public int insert(SysDept obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(SysDept obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public SysDept selectByPrimaryKey(Integer dept_id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(SysDept obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(SysDept record);
	  
}