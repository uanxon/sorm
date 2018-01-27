package com.jsjf.dao.borrow;

import com.jsjf.model.borrow.TBSysRole;

public interface TBSysRoleDAO {
	/**
	 * delete
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer role_ky);
	/**
	 * insert 所有属性
	 * @param record
	 * @return
	 */
	public int insert(TBSysRole obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(TBSysRole obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public TBSysRole selectByPrimaryKey(Integer role_ky);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(TBSysRole obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(TBSysRole record);
	  
}