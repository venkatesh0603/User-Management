package com.happiestMinds.dao;

import com.happiestMinds.utils.ApiResponse;
import com.happiestMinds.vo.UserVo;

/**
 * @author Mahesh Chouhan
 *
 */
public interface UserDao {
	
	public ApiResponse addUser(UserVo user);
	public ApiResponse getAllUser();
	public ApiResponse editUser(UserVo userVo);
	public ApiResponse deleteUser(Long id);
	
}
