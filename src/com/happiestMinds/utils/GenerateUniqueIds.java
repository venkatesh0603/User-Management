/**
 * 
 */
package com.happiestMinds.utils;

import java.util.UUID;

/**
 * @author Mahesh Chouhan
 *
 */
public class GenerateUniqueIds {

	public static long getUniqueLongId(){
		return Math.abs(UUID.randomUUID().getLeastSignificantBits());
	}
}
