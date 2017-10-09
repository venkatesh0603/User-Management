/**
 * 
 */
package com.happiestMinds.dao;

import com.happiestMinds.utils.ApiResponse;

/**
 * @author Mahesh Chouhan
 *
 */
public interface GioDao {

	/**
	 * @return
	 */
	ApiResponse getCountries();

	/**
	 * @param country
	 * @return
	 */
	ApiResponse getStates(long country);

	/**
	 * @param state
	 * @return
	 */
	ApiResponse getCities(long state);

}
