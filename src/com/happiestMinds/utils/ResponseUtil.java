/**
 * 
 */
package com.happiestMinds.utils;

import java.util.List;

import com.happiestMinds.vo.UserVo;

/**
 * @author Mahesh Chouhan
 *
 */
public class ResponseUtil {

	public static ApiResponse successfullyAdded(){
		return new ApiResponse(Constants.addedSuccessfullyCode, Constants.addedSuccessfullyMessage);
	}
	
	public static ApiResponse additionFailed(){
		return new ApiResponse(Constants.additionFailedCode, Constants.additionFailedMessage);
	}
	
	public static ApiResponse successfullyAdded(Object data){
		return new ApiResponse(Constants.addedSuccessfullyCode, Constants.addedSuccessfullyMessage,data);
	}

	public static ApiResponse inputNotProper() {
		return new ApiResponse(Constants.improperInputCode, Constants.improperInputMessage);
	}

	public static ApiResponse notAbleToRetriveFromDB() {
		return new ApiResponse(Constants.notAbleToRetriveFromDbCode, Constants.notAbleToRetriveFromDbMessage);	
		}

	public static ApiResponse successfullyRetrived(Object data) {
		return new ApiResponse(Constants.retrivedSuccessfullyCode, Constants.retrivedSuccessfullyMessage,data);
		}

	public static ApiResponse successfullyEdited() {
		return new ApiResponse(Constants.editSuccessfullyCode, Constants.editSuccessfullyMessage);	}

	public static ApiResponse editFailed() {
		return new ApiResponse(Constants.editFailedCode, Constants.editFailedMessage);
	}
	public static ApiResponse dataNotFoundInDb() {
		return new ApiResponse(Constants.dataNotFoundCode, Constants.dataNotFoundMessage);	
		}

	public static ApiResponse deletedSuccesfully() {
		return new ApiResponse(Constants.deletedSuccesfullCode, Constants.deletedSuccesfullMessage);	
	}

	public static ApiResponse deletionFailed() {
		return new ApiResponse(Constants.deletionfailedCode, Constants.deletionfailedMessage);	
	}
	}

