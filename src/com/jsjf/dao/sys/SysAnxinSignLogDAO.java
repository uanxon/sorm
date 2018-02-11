package com.jsjf.dao.sys;

import com.jsjf.model.sys.SysAnxinSignLog;

public interface SysAnxinSignLogDAO {
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
	public int insert(SysAnxinSignLog obj);
	/**
	 * insert 不为空的属性
	 * @param record
	 * @return
	 */
	public int insertSelective(SysAnxinSignLog obj);
	/**
	 * 查询
	 * @param id
	 * @return
	 */
	public SysAnxinSignLog selectByPrimaryKey(Integer id);
	/**
	 * 修改不为空的属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(SysAnxinSignLog obj);
	/**
	 * 修改所有属性
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKey(SysAnxinSignLog record);
	  
}